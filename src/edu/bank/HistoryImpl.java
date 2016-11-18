package edu.bank;

import java.util.Iterator;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class HistoryImpl implements MutableHistory {
    private java.util.Vector<Operation> ops = new java.util.Vector<Operation>();

    @Override
    public Iterator<Operation> getOperations() {
        return ops.iterator();
    }

    @Override
    public void addOperation(Operation op) {
        ops.add(op);
    }
}
