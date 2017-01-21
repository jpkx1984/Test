package edu.bank;

/**
 * Created by janusz on 20.01.17.
 */
public interface BankPrivateData {
    MutableAccount asMutableAccount(Account acc);
    java.util.Date getDate();
    Bank getSelf();
}
