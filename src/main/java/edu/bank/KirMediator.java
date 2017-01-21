package edu.bank;

import java.math.BigDecimal;

/**
 * Created by janusz on 21.01.17.
 */
public interface KirMediator {
    void registerBank(Bank b);
    String placeWireTransfer(String from, String to, BigDecimal amount);

    KirResponse getWireTransferStatus(String id);



    String newId();
}
