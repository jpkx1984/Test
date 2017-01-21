package edu.bank.ops;

import edu.bank.Account;
import edu.bank.BankHandle;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public class CapitalizationOperationImpl extends BalanceOperationImpl {
    @Override()
    public String getName() {
        return "Kapitalizacja";
    }

    @Override
    public void execute(BankHandle bh) {
        // TODO:
    }

    public CapitalizationOperationImpl(Account acc, BigDecimal amount) {
        super(acc, amount);
    }
}
