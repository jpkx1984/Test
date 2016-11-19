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
        return null;
    }

    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return null;
    }

    public OperationResult addOperation(Operation op) {
        this.operations.add(op);
        return null;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private Owner owner;
    private Vector<Operation> operations = new Vector<Operation>();

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
