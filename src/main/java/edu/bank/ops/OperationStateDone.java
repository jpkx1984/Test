package edu.bank.ops;

/**
 * Created by janusz on 20.01.17.
 */
public class OperationStateDone implements OperationState {
    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean isPending() {
        return false;
    }

    @Override
    public boolean isFailed() {
        return false;
    }

    @Override
    public boolean isOpen() { return false; }
}
