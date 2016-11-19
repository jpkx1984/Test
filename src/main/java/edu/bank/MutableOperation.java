package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface MutableOperation extends Operation {
    void setStatus(OperationStatus s);
}
