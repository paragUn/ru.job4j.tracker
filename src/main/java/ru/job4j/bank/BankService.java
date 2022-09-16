package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает бизнесс логику банковского приложения.
 * @author Roman
 * @version 1.0
 */
public class BankService {

    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами:
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * Метод принимает на вход пользователя и если его еще нет в системе,
     * пользователь добавляется.
     * Если пользователь уже есть в системе - ничего не происходит.
     * @param user Пользователь, которого нужно добавить в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Первоначально пользователя нужно найти по паспорту.
     * Для этого нужно использовать метод findByPassport.
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе есть проверка, что такого счета у пользователя еще нет.
     * @param passport строка с номером паспорта
     * @param account счет который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Этот метод ищет пользователя по номеру паспорта.
     * Перебираются все элементы, если найден - возвращает пользователя.
     * Если не найден - null.
     * @param passport строка с номером паспорта
     * @return User пользователь с данным номером паспорта
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User key : users.keySet()) {
           if (key.getPassport().equals(passport)) {
               result = key;
               break;
           }
        }
        return result;
    }

    /**
     * Метод ищет счет пользователя по реквизитам.
     * Сначала находит пользователя по паспорту,
     * Потом получает список счетов найденного пользователя.
     * Затем метод ищет в нем нужный счет
     * @param passport строка с номером паспорта
     * @param requisite строка с номером счета
     * @return Account счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            for (Account currentAccount : list) {
                if (currentAccount.getRequisite().equals(requisite)) {
                    result = currentAccount;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят), то метод должен вернуть false.
     * @param srcPassport строка паспорта пользователя который переводит деньги.
     * @param srcRequisite строка номер счета источника
     * @param destPassport строка паспорта пользователя которому переводит деньги.
     * @param destRequisite строка номер счета получателя
     * @param amount - колличства переводимых денег
     * @return true или false в зависимости от успешноcти перевода средств;
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Получение списка всех счетов пользователя
     * @param user пользователь, список счетов который нужно получить
     * @return возвращает список
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}