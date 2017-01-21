package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public interface Report<T> {
    T getResult();
    void build(Bank b);
}
