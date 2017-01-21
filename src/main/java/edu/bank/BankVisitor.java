package edu.bank;

import edu.bank.ops.Operation;

/**
 * Created by janusz on 11.12.16.
 */
public interface BankVisitor {
    void visit(BankVisitable v);
    void visit(Bank b);
    void visit(Account acc);
    void visit(Operation op);
}
