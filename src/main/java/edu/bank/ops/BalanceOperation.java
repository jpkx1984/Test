package edu.bank.ops;

import edu.bank.Account;
import edu.bank.ops.Operation;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public interface BalanceOperation extends Operation {
    BigDecimal getAmount();
    Account getAccount();
}
