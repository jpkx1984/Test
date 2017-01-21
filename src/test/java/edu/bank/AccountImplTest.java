package edu.bank;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

/**
 * Created by jkrysztofiak on 2016-11-19.
 */
public class AccountImplTest {
    private Owner owner;
    private AccountImpl acc;
    private AccountImpl acc2;
    @BeforeMethod
    public void setUp() throws Exception {
        this.owner = new OwnerImpl("John", "DOE", "123456");
        this.acc = new AccountImpl(owner, "ACC1");
        this.acc2 = new AccountImpl(owner, "ACC2", BigDecimal.valueOf(1000));
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetExternalNo() throws Exception {
        Assert.assertEquals(this.acc.getExternalNo(), "ACC1");
    }

    @Test
    public void testGetCreationDate() throws Exception {
        Assert.assertNotNull(this.acc.getCreationDate());
    }

    @Test
    public void testGetBalance() throws Exception {
        Assert.assertEquals(this.acc.getBalance(), BigDecimal.valueOf(0));
        Assert.assertEquals(this.acc2.getBalance(), BigDecimal.valueOf(1000));
    }

    @Test
    public void testSetBalance() throws Exception {
        acc.setBalance(BigDecimal.valueOf(666));
        Assert.assertEquals(this.acc.getBalance(), BigDecimal.valueOf(666));
    }

    @Test
    public void testGetOwner() throws Exception {
        Assert.assertNotNull(this.acc.getOwner());
        Assert.assertEquals(this.acc.getOwner().getPesel(), this.owner.getPesel());
    }

}