package edu.bank.ops;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface OperationStatus {
    boolean isExecutable();
    boolean isFinished();
    boolean isPending();
    boolean isFailed();
}
