package edu.bank;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface TransferOperation extends Operation {
    Account getSource();
    Account getTarget();
    BigDecimal getAmount();
}
