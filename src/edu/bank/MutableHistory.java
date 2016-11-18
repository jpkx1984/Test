package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface MutableHistory extends History {
    void addOperation(Operation op);
}
