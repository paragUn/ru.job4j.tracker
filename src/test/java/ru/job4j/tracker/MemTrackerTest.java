package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemTrackerTest {
    @Test
    public void whenTestFindById() {
        try (MemTracker memTracker = new MemTracker()) {
            Item bug = new Item("Bug");
            Item item = memTracker.add(bug);
            Item result = memTracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestFindAll() {
        try (MemTracker memTracker = new MemTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            memTracker.add(first);
            memTracker.add(second);
            Item result = memTracker.findAll().get(0);
            assertThat(result.getName()).isEqualTo(first.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        try (MemTracker memTracker = new MemTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            memTracker.add(first);
            memTracker.add(second);
            memTracker.add(new Item("First"));
            memTracker.add(new Item("Second"));
            memTracker.add(new Item("First"));
            List<Item> result = memTracker.findByName(first.getName());
            assertThat(result.size()).isEqualTo(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        try (MemTracker memTracker = new MemTracker()) {
            Item first = new Item("First");
            Item second = new Item("Second");
            memTracker.add(first);
            memTracker.add(second);
            memTracker.add(new Item("First"));
            memTracker.add(new Item("Second"));
            memTracker.add(new Item("First"));
            List<Item> result = memTracker.findByName(second.getName());
            assertThat(result.get(1).getName()).isEqualTo(second.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenReplace() {
        try (MemTracker memTracker = new MemTracker()) {
            Item bug = new Item();
            bug.setName("Bug");
            memTracker.add(bug);
            int id = bug.getId();
            Item bugWithDesc = new Item();
            bugWithDesc.setName("Bug with description");
            memTracker.replace(id, bugWithDesc);
            assertThat(memTracker.findById(id).getName()).isEqualTo("Bug with description");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenDelete() {
        try (MemTracker memTracker = new MemTracker()) {
            Item bug = new Item();
            bug.setName("Bug");
            memTracker.add(bug);
            int id = bug.getId();
            memTracker.delete(id);
            assertThat(memTracker.findById(id)).isNull();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}