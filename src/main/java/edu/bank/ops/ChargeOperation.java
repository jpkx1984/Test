package edu.bank.ops;

import edu.bank.Account;
import edu.bank.BankPrivateData;

import java.math.BigDecimal;

/**
 * Created by janusz on 21.01.17.
 */
public class ChargeOperation extends OperationBase {
    @Override
    public String getName() {
        return "Wpłata gotówkowa";
    }

    private Account account;
    private BigDecimal amount;

    public Account getAccount() {
        return this.account;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public ChargeOperation(Account account, BigDecimal amount) {
        if (account == null || amount == null)
            throw new IllegalArgumentException();

        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute(BankPrivateData bh) {
        if (this.getAccount().isBalanceMutable()) {
            this.setStatus(new OperationStateFailed());
            return;
        }

        bh.asMutableAccount(this.getAccount()).addBalance(this.getAmount());
        this.setStatus(new OperationStateDone());
    }
}
