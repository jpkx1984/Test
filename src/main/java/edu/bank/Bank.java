package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Bank {
    Controller getController();
    void addAccount(Account acc);
    Iterable<Account> getAccounts();
    Account findAccount(String id);
}
