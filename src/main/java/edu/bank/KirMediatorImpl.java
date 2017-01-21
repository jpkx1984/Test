package edu.bank;

import java.math.BigDecimal;

/**
 * Created by janusz on 21.01.17.
 */
public class KirMediatorImpl implements KirMediator {
    private java.util.HashSet<Bank> banks = new java.util.HashSet<Bank>();
    private java.util.HashMap<String, KirResponse> responses = new java.util.HashMap<String, KirResponse>();

    @Override
    public void registerBank(Bank b) {
        this.banks.add(b);
    }

    @Override
    public String placeWireTransfer(String from, String to, BigDecimal amount) {
        Account fromAccount = null;
        Account toAccount = null;
        final String reqId = this.newId();

        for (Bank b : this.banks) {
            fromAccount = b.findAccount(from);
            toAccount = b.findAccount(to);
        }

        if (toAccount == null) {
            this.responses.put(reqId, new KirResponseImpl(reqId, KirStatus.FAIL, "Docelowe konto nie istnieje."));
        } else {

        }
    }

    @Override
    public KirResponse getWireTransferStatus(String id) {
        return null;
    }

    @Override
    public String newId() {
        // TODO:
        return null;
    }

    private static KirMediator kirMediator = null;

    public static KirMediator getInstance() {
        if (kirMediator == null) {
            kirMediator = new KirMediatorImpl();
        }

        return kirMediator;
    }
}
