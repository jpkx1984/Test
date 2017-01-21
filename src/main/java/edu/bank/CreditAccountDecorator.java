package edu.bank;

import edu.bank.ops.OperationStatus;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by janusz on 10.12.16.
 */
public class CreditAccountDecorator implements CreditAccount, Tickable {
    private Account account;
    private InterestStrategy interestStrategy;

    public CreditAccountDecorator(Account account) {
        this.account = account;
    }

    @Override
    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public InterestStrategy getInterestStrategy() {
        return this.interestStrategy;
    }

    @Override
    public String getExternalNo() {
        return this.account.getExternalNo();
    }

    @Override
    public Date getCreationDate() {
        return this.account.getCreationDate();
    }

    @Override
    public BigDecimal getBalance() {
        return this.account.getBalance().subtract(this.debt);
    }

    @Override
    public Owner getOwner() {
        return this.account.getOwner();
    }

    @Override
    public Bank getBank() {
        return this.account.getBank();
    }

    private Date prevDate;
    private BigDecimal debt = BigDecimal.valueOf(0);

    protected void setBalance(BigDecimal d) {
        ((MutableAccount)this.account).setBalance(d);
    }

    @Override
    public void doTick(Date d) {

    }

    @Override
    public void acceptVisitor(BankVisitor v) {
        v.visit(this);
    }
}
