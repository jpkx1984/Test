package edu.bank;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface MutableAccount extends Account {
    void setBalance(BigDecimal balance);
    void addBalance(BigDecimal delta);
    void subtractBalance(BigDecimal delta);
    void setState(AccountState state);
}
