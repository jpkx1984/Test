package edu.bank;

/**
 * Created by janusz on 20.01.17.
 */
public interface BankHandle {
    MutableAccount getMutableAccount(Account acc);
    java.util.Date getDate();
}
