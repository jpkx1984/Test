package edu.bank.ops;

import edu.bank.Account;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public abstract class BalanceOperationImpl extends OperationImpl implements BalanceOperation {
    private BigDecimal amount;
    private Account account;

    BalanceOperationImpl(Account acc, BigDecimal amount) {
        this.amount = amount;
        this.account = acc;
    }

    public Account getAccount() {
        return this.account;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }
}
