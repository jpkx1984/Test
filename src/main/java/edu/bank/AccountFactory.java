package edu.bank;

/**
 * Created by janusz on 20.01.17.
 */
public interface AccountFactory {
    Account newAccount(Owner o);
    SavingsAccount newSavingsAccount(Account acc);
}
