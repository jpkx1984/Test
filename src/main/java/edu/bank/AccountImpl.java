package edu.bank;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class AccountImpl implements MutableAccount {
    private String externalId;

    public String getExternalNo() {
        return externalId;
    }

    private Date creationDate;

    public Date getCreationDate() {
        return this.creationDate;
    }

    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public BigDecimal getAvailableFunds() {
        return this.getBalance().compareTo(BigDecimal.ZERO) > 0 ? this.getBalance() : BigDecimal.ZERO;
    }

    private Bank bank;


    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private Owner owner;

    public Owner getOwner() {
        return this.owner;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    AccountImpl(Bank bank, Owner owner, String externalNo) {
        this.bank = bank;
        this.externalId = externalNo;
        this.creationDate = Calendar.getInstance().getTime();
        this.owner = owner;
    }

    AccountImpl(Bank bank, Owner owner, String externalNo, BigDecimal balance) {
        this.externalId = externalNo;
        this.creationDate = Calendar.getInstance().getTime();
        this.balance = balance;
    }

    @Override
    public void doTick(Date d) {
    }

    @Override
    public void acceptVisitor(BankVisitor v) {
        v.visit(this);
    }
}
