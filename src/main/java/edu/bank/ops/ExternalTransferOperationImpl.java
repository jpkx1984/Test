package edu.bank.ops;

import edu.bank.*;

import java.math.BigDecimal;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class ExternalTransferOperationImpl extends OperationBase implements ExternalTransferOperation {
    private String source;
    private String target;
    private String kirOpId = null;

    @Override
    public String getName() {
        return "Przelew zewnętrzny";
    }

    @Override
    public void execute(BankPrivateData bh) {
        final KirMediator kir = KirMediatorImpl.getInstance();

        final Account acc = bh.getSelf().findAccount(this.getSource());

        // konto nie istnieje lub nie może już zmieniać stanu
        if (acc == null || !acc.isBalanceMutable()) {
            this.setStatus(new OperationStateFailed());
            return;
        }

        if (this.isOpen()) { // wyślij transakcję do KIRu
            this.kirOpId = kir.placeWireTransfer(this.getSource(), this.getTarget(), this.getAmount());
            this.setStatus(new OperationStatePending());
        } else if (this.isPending()) { // pytaj KIR o rezultat
            final KirResponse kirResp = kir.getWireTransferStatus(this.kirOpId);

            if (kirResp.getStatus() == KirStatus.OK) {
                bh.asMutableAccount(acc).subtractBalance(this.getAmount());
                this.setStatus(new OperationStateDone());
            } else if (kirResp.getStatus() == KirStatus.FAIL) {
                this.setComment(kirResp.getComment());
                this.setStatus(new OperationStateFailed());
            }
        }
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
