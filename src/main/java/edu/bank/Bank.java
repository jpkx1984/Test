package edu.bank;

import edu.bank.ops.Operation;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Bank extends BankVisitable, Tickable {
    AccountFactory getAccountFactory();
    Iterable<Account> getAccounts();
    Account findAccount(String id);
    History getHistory();
    void addOperation(Operation op);
}
