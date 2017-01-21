package edu.bank.ops;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public abstract class OperationImpl implements Operation {
    private Date creationTime;
    private OperationStatus status = new OperationStateOpen();
    private java.util.Vector<Consumer<Operation>> listeners = new java.util.Vector<Consumer<Operation>>();

    public Date getCreationTime() {
        return this.creationTime;
    }

    private Date lastChangeTime;

    public Date getLastChangeTime() {
        return this.lastChangeTime;
    }

    protected void setStatus(OperationStatus st) {
        this.lastChangeTime = Calendar.getInstance().getTime();
        this.status = st;
    }

    public OperationStatus getStatus() {
        return this.status;
    }

    protected  OperationImpl() {
        this.creationTime = Calendar.getInstance().getTime();
    }

    public boolean isExecutable() {
        return this.status.isExecutable();
    }

    public boolean isPending() {
        return this.status.isPending();
    }

    public boolean isFailed() {
        return this.status.isFailed();
    }

    public boolean isFinished() {
        return this.status.isFinished();
    }
}
