package edu.bank;

/**
 * Created by janusz on 11.12.16.
 */
public interface BankVisitable {
    void acceptVisitor(BankVisitor v);
}
