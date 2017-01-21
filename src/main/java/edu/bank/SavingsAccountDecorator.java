package edu.bank;

import edu.bank.ops.Operation;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by janusz on 20.01.17.
 */
public class SavingsAccountDecorator implements SavingsAccount {
    private Account account;
    private InterestStrategy interestStrategy;
    public SavingsAccountDecorator(Account acc) {
        this.account = acc;
    }

    @Override
    public void acceptVisitor(BankVisitor v) {

    }

    @Override
    public void doTick(Date d) {

    }

    @Override
    public void setInterestStrategy(InterestStrategy str) {
        this.interestStrategy = str;
    }

    @Override
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
        return this.account.getBalance();
    }

    @Override
    public Owner getOwner() {
        return this.account.getOwner();
    }

    @Override
    public Bank getBank() {
        return this.account.getBank();
    }
}
