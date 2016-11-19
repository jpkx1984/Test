package edu.bank;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public abstract class OperationImpl implements MutableOperation {
    private Date creationTime;
    private OperationStatus status = OperationStatus.OPEN;
    private java.util.Vector<Consumer<Operation>> listeners = new java.util.Vector<Consumer<Operation>>();

    @Override
    public Date getCreationTime() {
        return this.creationTime;
    }

    private Date lastChangeTime;

    @Override
    public Date getLastChangeTime() {
        return null;
    }

    @Override
    public OperationStatus getStatus() {
        return this.status;
    }

    public void setStatus(OperationStatus status) {
        this.lastChangeTime = Calendar.getInstance().getTime();
        this.status = status;
        this.fireStatusChange();
    }

    protected  OperationImpl() {
        this.creationTime = Calendar.getInstance().getTime();
        this.setStatus(OperationStatus.OPEN);
    }

    protected void fireStatusChange() {
        this.listeners.forEach((l) -> l.accept(this));
    }

    @Override
    public void addStatusChangeListener(Consumer<Operation> listener) {
        this.listeners.add(listener);
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
