package edu.bank.ops;

import edu.bank.BankPrivateData;

import java.util.Date;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Operation extends OperationState {
    String getName();
    Date getCreationTime();
    Date getLastChangeTime();

    void execute(BankPrivateData bh);
    String getComment();
}
