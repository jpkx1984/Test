package edu.bank;

import edu.bank.ops.Operation;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class HistoryImpl implements MutableHistory {
    private java.util.Vector<Operation> ops = new java.util.Vector<Operation>();

    public Iterable<Operation> getOperations() {
        return ops;
    }

    public void addOperation(Operation op) {
        ops.add(op);
    }
}
