package edu.bank;

import edu.bank.ops.Operation;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface History {
    Iterable<Operation> getOperations();
}
