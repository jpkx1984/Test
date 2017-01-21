package edu.bank;

import edu.bank.ops.OperationBase;
import edu.bank.ops.OperationStateDone;
import edu.bank.ops.OperationStateFailed;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by janusz on 20.01.17.
 */
public class SavingsAccountDecorator implements SavingsAccount {
    private Account account;
    private InterestStrategy interestStrategy;
    public SavingsAccountDecorator(Account acc) {
        this.account = acc;
    }

    @Override
    public void acceptVisitor(BankVisitor v) {

    }

    @Override
    public void doTick(Date d) {
        this.getBank().addOperation(new OperationBase() {
            @Override
            public String getName() {
                return "Kapitalizacja";
            }

            @Override
            public void execute(BankPrivateData bh) {
                if (!SavingsAccountDecorator.this.isBalanceMutable()) {
                    this.setStatus(new OperationStateFailed());
                    return;
                }
                BigDecimal interest = SavingsAccountDecorator.this.getInterestStrategy().getInterestAmount(SavingsAccountDecorator.this);
                bh.asMutableAccount(SavingsAccountDecorator.this).addBalance(interest);

                this.setStatus(new OperationStateDone());
            }
        });
    }

    @Override
    public void setInterestStrategy(InterestStrategy str) {
        this.interestStrategy = str;
    }

    @Override
    public InterestStrategy getInterestStrategy() {
        return this.interestStrategy;
    }

    @Override
    public String getExternalNo() {
        return this.account.getExternalNo();
    }

    @Override
    public Date getCreationDate() {
        return this.account.getCreationDate();
    }

    @Override
    public BigDecimal getBalance() {
        return this.account.getBalance();
    }

    @Override
    public BigDecimal getAvailableFunds() {
        // TODO:
        return this.getBalance();
    }

    @Override
    public Owner getOwner() {
        return this.account.getOwner();
    }

    @Override
    public Bank getBank() {
        return this.account.getBank();
    }

    @Override
    public boolean isBalanceMutable() {
        return this.account.isBalanceMutable();
    }
}
