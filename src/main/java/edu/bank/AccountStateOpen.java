package edu.bank;

/**
 * Created by janusz on 21.01.17.
 */
public class AccountStateOpen implements AccountState {
    @Override
    public boolean isBalanceMutable(Account acc) {
        return true;
    }
}
