package edu.bank.ops;

import edu.bank.BankPrivateData;

/**
 * Created by janusz on 21.01.17.
 */
public class IncomingExternalTransfer extends OperationBase {

    @Override
    public String getName() {
        return "Nadchodzący przelew zewnętrzny";
    }

    @Override
    public void execute(BankPrivateData bh) {

    }

    public IncomingExternalTransfer(String accountId) {

    }
}
