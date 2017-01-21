package edu.bank;

import edu.bank.ops.TransferOperationImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

import static org.testng.Assert.*;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public class ControllerTest {
    private Owner owner;
    private InterestStrategy interestStrategy;
    private Account acc1;
    private Account acc2;
    private Account acc3;
    private Bank bank;

    @BeforeMethod
    public void setUp() throws Exception {
        this.owner = new OwnerImpl("Jan", "Kowalski", "2222");
        this.interestStrategy = new SimpleInterestStrategy();
        /*
        this.acc1 = new AccountImpl(this.owner, "Acc1", BigDecimal.valueOf(1000));
        this.acc2 = new AccountImpl(this.owner, "Acc2", BigDecimal.valueOf(1000));
        this.acc3 = null;
        this.bank = new BankImpl();

        this.bank.addAccount(acc1);
        this.bank.addAccount(acc2);
        this.bank.addAccount(acc3);
        */

        //this.controller = this.bank.getController();
    }

    @Test
    public void testDoTick1() throws Exception {
        final BigDecimal before = acc3.getBalance();

        //this.controller.doTick(Date.from(Instant.now()));

        final BigDecimal after = acc3.getBalance();

        assertEquals(after.subtract(before), BigDecimal.valueOf(100));
    }

    @Test
    public void testDoOp() throws Exception {
        final BigDecimal before = acc1.getBalance();

        //this.controller.doOp(new TransferOperationImpl(acc2, acc1, BigDecimal.valueOf(100)));

        final BigDecimal after = acc1.getBalance();

        assertEquals(after.subtract(before), BigDecimal.valueOf(100));
    }
}