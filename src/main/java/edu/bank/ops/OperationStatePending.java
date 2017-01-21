package edu.bank.ops;

/**
 * Created by janusz on 20.01.17.
 */
public class OperationStatePending implements OperationState {
    @Override
    public boolean isExecutable() {
        return true;
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

    @Override
    public boolean isOpen() { return false; }
}
