package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface History {
    java.util.Iterator<Operation> getOperations();
}
