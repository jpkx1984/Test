package edu.bank;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Operation {
    String getName();
    Date getCreationTime();
    Date getLastChangeTime();
    OperationStatus getStatus();

    void addStatusChangeListener(Consumer<Operation> listener);

    boolean isValid();
}
