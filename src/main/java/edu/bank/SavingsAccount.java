package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface SavingsAccount extends Account {
    void setInterestStrategy(InterestStrategy str);
    InterestStrategy getInterestStrategy();
}
