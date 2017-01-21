package edu.bank.ops;

/**
 * Created by janusz on 20.01.17.
 */
public class OperationStatePending implements OperationStatus {
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
        return true;
    }

    @Override
    public boolean isFailed() {
        return false;
    }
}
