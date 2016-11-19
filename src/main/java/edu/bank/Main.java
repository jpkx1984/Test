package edu.bank;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        final Bank bank = BankImpl.getInstance();

        final Owner o1 = new OwnerImpl("Jan", "Kowalski", "666");
        final Owner o2 = new OwnerImpl("Jan", "Nowak", "667");

        final Account acc1 = new AccountImpl(o1, "ACC1", BigDecimal.valueOf(1000));
        final Account acc2 = new AccountImpl(o1, "ACC2", BigDecimal.valueOf(1000));

        final Controller controller = bank.getController();

        bank.getAccounts().forEach((acc) -> System.out.println(acc.getBalance()));

        controller.doOp(new TransferOperationImpl(acc1, acc2, BigDecimal.valueOf(200)));
        bank.getAccounts().forEach((acc) -> System.out.println(acc.getBalance()));

    }
}
