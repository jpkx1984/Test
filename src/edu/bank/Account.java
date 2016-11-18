package edu.bank;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Account {
    String getExternalNo();
    Date getCreationDate();
    BigDecimal getBalance();
    Owner getOwner();
}
