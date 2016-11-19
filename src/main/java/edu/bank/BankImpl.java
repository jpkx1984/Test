package edu.bank;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class BankImpl implements Bank {
    private static Bank bank = null;
    public static Bank getInstance() {
        if (bank == null) {
            bank = new BankImpl();
        }

        return bank;
    }

    private MutableHistory history;
    private Controller controller;

    protected BankImpl() {
        this.history = new HistoryImpl();
        this.controller = new Controller(this, this.history);
    }

    public Controller getController() {
        return this.controller;
    }

    private java.util.HashMap<String, Account> accounts = new java.util.HashMap<String, Account>();

    public Account findAccount(String acc) {
        return this.accounts.get(acc);
    }

    public void addAccount(Account acc) {
        if (this.accounts.containsKey(acc.getExternalNo())) {
            throw new UnsupportedOperationException();
        }

        this.accounts.put(acc.getExternalNo(), acc);
    }

    public Iterable<Account> getAccounts() {
        return this.accounts.values();
    }
}
