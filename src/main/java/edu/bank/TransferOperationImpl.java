package edu.bank;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class TransferOperationImpl extends OperationImpl implements TransferOperation {
    private Account source;
    private Account target;

    public Account getSource() {
        return this.source;
    }

    public Account getTarget() {
        return this.target;
    }

    public String getName() {
        return "Przelew";
    }

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public TransferOperationImpl(Account from, Account to, BigDecimal amount) {
        this.source = from;
        this.target = to;
        this.amount = amount;
    }
}
