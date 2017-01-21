package edu.bank;

import edu.bank.ops.BalanceOperation;
import edu.bank.ops.ExternalTransferOperation;
import edu.bank.ops.Operation;
import edu.bank.ops.TransferOperation;

import java.math.BigDecimal;

class OperationPrinter implements OperationVisitor {
    public void doOp(Operation op) {
        System.out.println(op.getName());
    }

    public void doOp(BalanceOperation op) {
        System.out.println(String.format("%1$s %2$s", op.getName(), op.getAmount().toString()));
    }

    public void doOp(TransferOperation op) {
        System.out.println(String.format("%1$s %2$s", op.getName(), op.getAmount().toString()));
    }

    public void doOp(ExternalTransferOperation op) {
        System.out.println(String.format("%1$s %2$s", op.getName(), op.getAmount().toString()));
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");
        final Bank bank = new BankImpl();
        final Bank bank2 = new BankImpl();


    }
}
