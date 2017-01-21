package edu.bank.ops;

import edu.bank.BankHandle;

import java.util.Date;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Operation extends OperationStatus {
    String getName();
    Date getCreationTime();
    Date getLastChangeTime();

    void execute(BankHandle bh);
}
