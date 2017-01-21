package edu.bank;

/**
 * Created by janusz on 21.01.17.
 */
public interface KirResponse {
    KirStatus getStatus();
    String getComment();
    String getId();
}
