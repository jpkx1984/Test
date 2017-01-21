package edu.bank;

/**
 * Created by janusz on 21.01.17.
 */
public class KirResponseImpl implements KirResponse {
    private String id;
    private KirStatus status;
    private String comment;

    @Override
    public KirStatus getStatus() {
        return null;
    }

    @Override
    public String getComment() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    public KirResponseImpl(String id, KirStatus status, String comment) {
        this.id = id;
        this.status = status;
        this.comment = comment;
    }
}
