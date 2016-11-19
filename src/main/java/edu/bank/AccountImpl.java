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

    @Override
    public String getExternalNo() {
        return externalId;
    }

    private Date creationDate;

    @Override
    public Date getCreationDate() {
        return null;
    }

    private BigDecimal balance = new BigDecimal(0);

    @Override
    public BigDecimal getBalance() {
        return null;
    }

    @Override
    public OperationResult addOperation(Operation op) {
        this.operations.add(op);
        return null;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private Owner owner;
    private Vector<Operation> operations = new Vector<Operation>();

    @Override
    public Owner getOwner() {
        return null;
    }

    AccountImpl(Owner owner, String externalNo) {
        this.externalId = externalNo;
        this.creationDate = Calendar.getInstance().getTime();
    }

    AccountImpl(Owner owner, String externalNo, BigDecimal balance) {
        this.externalId = externalNo;
        this.creationDate = Calendar.getInstance().getTime();
        this.balance = balance;
    }
}
