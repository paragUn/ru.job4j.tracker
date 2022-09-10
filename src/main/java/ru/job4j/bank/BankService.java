package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> value;
        for (User key : users.keySet()) {
            if (user != null && user.getPassport().equals(key.getPassport())) {
                value = users.get(key);
                if (!value.contains(account)) {
                    value.add(account);
                }
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User key : users.keySet()) {
           if (key.getPassport().equals(passport)) {
               result = key;
           }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        List<Account> value = null;
        User user = findByPassport(passport);
        for (User key : users.keySet()) {
            if (user != null && user.getPassport().equals(key.getPassport())) {
                value = users.get(key);
            }
        }
        if (value != null) {
            for (Account currentQAccount : value) {
                if (currentQAccount.getRequisite().equals(requisite)) {
                    result = currentQAccount;
                }
            }
        }
        return result;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}