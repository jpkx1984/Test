package edu.bank.ops;

import edu.bank.Account;
import edu.bank.AccountStateClosed;
import edu.bank.BankPrivateData;

/**
 * Created by janusz on 21.01.17.
 */
public class CloseAccountOperation extends OperationBase {
    private Account account;
    @Override
    public String getName() {
        return "Zamykanie konta";
    }

    public Account getAccount() {
        return this.account;
    }

    @Override
    public void execute(BankPrivateData bh) {
        bh.asMutableAccount(this.account).setState(new AccountStateClosed());
        this.setStatus(new OperationStateDone());
    }

    public CloseAccountOperation(Account acc) {
        if (acc == null) throw new IllegalArgumentException();

        this.account = acc;
    }
}
