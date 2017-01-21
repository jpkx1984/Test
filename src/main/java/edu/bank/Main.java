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
        final Bank bank = BankImpl.getInstance();
        final Bank bank2 = new BankImpl();

        final Owner o1 = new OwnerImpl("Jan", "Kowalski", "666");
        final Owner o2 = new OwnerImpl("Jan", "Nowak", "667");

        final Account acc1 = new AccountImpl(o1, "ACC1", BigDecimal.valueOf(1000));
        final Account acc2 = new AccountImpl(o1, "ACC2", BigDecimal.valueOf(1000));
        //final Account acc3 = new SavingAccountImpl(o1, "ACC3", new SimpleInterestStrategy(), BigDecimal.valueOf(1000));


        bank.addAccount(acc1);
        bank.addAccount(acc2);
        //bank.addAccount(acc3);

        //final Controller controller = bank.getController();

        System.out.println("Stany kont:");
        bank.getAccounts().forEach((acc) ->
        {
            System.out.println(acc.getExternalNo());
            System.out.println(acc.getBalance());
        });


        //controller.doOp(new TransferOperationImpl(acc1, acc2, BigDecimal.valueOf(200)));

        //controller.doTick(java.util.Date.from(Instant.now()));

        ExampleReport rep1 = new ExampleReport();

        rep1.build(bank);

        System.out.println("Liczba operacji");
        rep1.getResult().entrySet().stream().forEach(es -> System.out.println(String.format("%1$s: %1$d", es.getKey(), es.getValue())));

        System.out.println("Stany kont:");
        bank.getAccounts().forEach((acc) ->
        {
            System.out.println(acc.getExternalNo());
            System.out.println(acc.getBalance());
        });

        System.out.println("Historia:");
        OperationPrinter printer = new OperationPrinter();
        bank.getHistory().getOperations().forEach((op) -> {
            //op.acceptVisitor(printer);
        });
    }
}
