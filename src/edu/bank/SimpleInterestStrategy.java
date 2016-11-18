package edu.bank;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
class SimpleInterestStrategy implements InterestStrategy {

    @Override
    public BigDecimal getInterestAmount(Account acc, long interval) {
        return acc.getBalance().divide(BigDecimal.valueOf(10));
    }
}
