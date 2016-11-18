package edu.bank;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class ExternalTransferOperationImpl extends OperationImpl implements ExternalTransferOperation {
    private String source;
    private String target;

    @Override
    public String getName() {
        return "Przelew zewnętrzny";
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public String getTarget() {
        return this.target;
    }

    private BigDecimal amount;

    @Override
    public BigDecimal getAmount() {
        return this.amount;
    }

    public ExternalTransferOperationImpl(String source, String target, BigDecimal amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }
}
