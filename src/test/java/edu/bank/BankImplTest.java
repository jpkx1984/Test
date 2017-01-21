package edu.bank;

import org.testng.annotations.BeforeMethod;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public class BankImplTest {
    private Owner owner;
    private Bank bank;
    private Account acc1;
    private Account acc2;


    @BeforeMethod
    public void setUp() throws Exception {
        this.owner = new OwnerImpl("John", "DOE", "123456");
        this.bank = new BankImpl();
        this.acc1 = new AccountImpl(owner, "AC1", BigDecimal.valueOf(0));
        this.acc2 = new AccountImpl(owner, "AC3", BigDecimal.valueOf(0));

        //
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() throws Exception {

    }

    @org.testng.annotations.Test
    public void testGetInstance() throws Exception {
        assertNotNull(BankImpl.getInstance());
    }

    @org.testng.annotations.Test
    public void testGetHistory() throws Exception {

    }

    @org.testng.annotations.Test
    public void testGetController() throws Exception {

    }

    @org.testng.annotations.Test
    public void testFindAccount() throws Exception {

    }

    @org.testng.annotations.Test
    public void testAddAccount() throws Exception {
        this.bank.addAccount(acc1);
        this.bank.addAccount(acc2);
        int c = 0;

        for (Account acc : this.bank.getAccounts()) {
            ++c;
        }

        assertEquals(c, 2);
    }

    @org.testng.annotations.Test
    public void testAddAccount2() throws Exception {
        try {
            this.bank.addAccount(acc1);
            this.bank.addAccount(acc2);
            this.bank.addAccount(acc2);
            int c = 0;

            for (Account acc : this.bank.getAccounts()) {
                ++c;
            }

            fail("Two accounts with single external ID are disallowed.");
            //assertEquals(c, 2, "Two accounts with single external ID are disallowed.");
        }

        catch (UnsupportedOperationException ex) {
        }
    }
}