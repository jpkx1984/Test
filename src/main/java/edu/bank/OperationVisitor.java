package edu.bank;

import edu.bank.ops.BalanceOperation;
import edu.bank.ops.ExternalTransferOperation;
import edu.bank.ops.Operation;
import edu.bank.ops.TransferOperation;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public interface OperationVisitor {
    void doOp(Operation op);
    void doOp(BalanceOperation op);
    void doOp(TransferOperation op);
    void doOp(ExternalTransferOperation op);
}
