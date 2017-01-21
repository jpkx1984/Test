package edu.bank.ops;

import edu.bank.Account;
import edu.bank.BankHandle;
import edu.bank.MutableAccount;

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

    @Override
    public void execute(BankHandle bh) {
        if (!this.isExecutable())
            return;

        final MutableAccount a = bh.getMutableAccount(this.getSource());
        final MutableAccount b = bh.getMutableAccount(this.getTarget());

        if (a.getAvailableFunds().compareTo(this.getAmount()) >= 0) {
            a.setBalance(a.getBalance().subtract(this.getAmount()));
            b.setBalance(b.getBalance().add(this.getAmount()));

            this.setStatus(new OperationStateDone());
        } else {
            this.setStatus(new OperationStateFailed());
        }
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
