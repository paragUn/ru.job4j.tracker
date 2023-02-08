package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenAddThenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item1"));
        Item item2 = new Item("item2");
        item2.setId(item.getId());
        assertThat(tracker.replace(item.getId(), item2)).isTrue();
        assertThat(tracker.findByName(item2.getName())).isEqualTo(List.of(item2));
    }

    @Test
    public void whenAddThenDeleteMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item1");
        tracker.add(item);
        assertThat(tracker.delete(item.getId())).isTrue();
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenAddThenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item1");
        tracker.add(item);
        assertThat(tracker.findByName("item1"))
                .isEqualTo(List.of(item))
                .hasSize(1);
    }
}