package edu.bank;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface MutableAccount extends Account {
    OperationResult addOperation(Operation op);
    void setBalance(BigDecimal balance);
}
