package edu.bank;

import java.util.function.Consumer;

class KIRController {
    private java.util.Queue<ExternalTransferOperation> ops = new java.util.PriorityQueue<ExternalTransferOperation>();
    public void enqueueOp(ExternalTransferOperation op) {
        if (op.getStatus() == OperationStatus.DONE || !op.isValid()) {
            return;
        }

        this.ops.add(op);
    }

    private java.util.Vector<Consumer<Operation>> listeners = new java.util.Vector<Consumer<Operation>>();

    public void addListener(Consumer<Operation> l) {
        this.listeners.add(l);
    }

    public void process() {
        ops.stream().map((op) -> (MutableOperation)op).forEach((op) -> op.setStatus(OperationStatus.DONE));
    }
}

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class Controller {
    private KIRController kirController = new KIRController();
    private Bank bank;
    private MutableHistory history;

    public Controller(Bank bank, MutableHistory hist) {
        this.bank = bank;
        this.history = hist;
    }

    public void doOp(TransferOperation op) {
        if (op.getStatus() == OperationStatus.DONE) {
            return;
        }

        if (!op.isValid()) {
            return;
        }

        this.history.addOperation(op);

        final MutableAccount s = (MutableAccount) op.getSource();
        final MutableAccount t = (MutableAccount) op.getTarget();

        s.setBalance(s.getBalance().subtract(op.getAmount()));
        t.setBalance(t.getBalance().add(op.getAmount()));

        ((MutableOperation)op).setStatus(OperationStatus.DONE);
    }

    private void handleExtTransfer(Operation o) {
        if (o.getStatus() == OperationStatus.DONE) {
            final ExternalTransferOperation op = (ExternalTransferOperation)o;

            this.history.addOperation(op);

            final MutableAccount src = (MutableAccount) this.bank.findAccount(op.getSource());
            final MutableAccount target = (MutableAccount) this.bank.findAccount(op.getTarget());

            if (src != null) {
                src.setBalance(src.getBalance().subtract(op.getAmount()));
            } else {
                target.setBalance(target.getBalance().add(op.getAmount()));
            }
        }
    }

    public void doOp(ExternalTransferOperation op) {
        if (op.getStatus() == OperationStatus.DONE) {
            return;
        }

        if (!op.isValid()) {
            return;
        }

        final Account src = this.bank.findAccount(op.getSource());
        final Account target = this.bank.findAccount(op.getTarget());

        if (src == target) {
            return;
        }

        op.addStatusChangeListener(this::handleExtTransfer);

        this.kirController.enqueueOp(op);
    }

    public void process() {
        for (Account acc : this.bank.getAccounts()) {

        }
    }
}
