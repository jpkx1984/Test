package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface CreditAccount extends Account {
    void setInterestStrategy(InterestStrategy interestStrategy);
}
