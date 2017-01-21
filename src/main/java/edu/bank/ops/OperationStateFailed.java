package edu.bank.ops;

/**
 * Created by janusz on 20.01.17.
 */
public class OperationStateFailed implements OperationStatus {
    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isPending() {
        return false;
    }

    @Override
    public boolean isFailed() {
        return true;
    }
}
