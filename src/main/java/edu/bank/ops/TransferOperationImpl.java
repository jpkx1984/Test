package edu.bank.ops;

import edu.bank.Account;
import edu.bank.BankPrivateData;
import edu.bank.MutableAccount;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class TransferOperationImpl extends OperationBase implements TransferOperation {
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
    public void execute(BankPrivateData bh) {
        if (!this.isExecutable())
            return;

        final MutableAccount a = bh.asMutableAccount(this.getSource());
        final MutableAccount b = bh.asMutableAccount(this.getTarget());

        if (a.getAvailableFunds().compareTo(this.getAmount()) >= 0 && a.isBalanceMutable() && b.isBalanceMutable()) {
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
