package edu.bank;

import edu.bank.ops.Operation;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jkrysztofiak on 2016-11-05.
 */
public class BankImpl implements Bank, Tickable {
    public History getHistory() {
        return this.history;
    }
    private ArrayList<Operation> ops = new ArrayList<Operation>();
    private java.util.Date currentDate;
    private BankPrivateData bankHandle = new BankPrivateData() {
        private java.util.Date d;

        public Bank getSelf() {
            return BankImpl.this;
        }

        @Override
        public MutableAccount asMutableAccount(Account acc) {
            // TODO:
            return (MutableAccount)acc;
        }

        @Override
        public Date getDate() {
            return BankImpl.this.currentDate;
        }
    };

    protected BankPrivateData getBankHandle() {
        return this.bankHandle;
    }

    @Override
    public void addOperation(Operation op) {
        this.ops.add(op);
    }


    private MutableHistory history;

    public BankImpl() {
        final BankImpl th = this;
        this.history = new HistoryImpl();
    }

    private java.util.HashMap<String, Account> accounts = new java.util.HashMap<String, Account>();

    public Account findAccount(String acc) {
        return this.accounts.get(acc);
    }

    protected void addAccount(Account acc) {
        if (this.accounts.containsKey(acc.getExternalNo())) {
            throw new UnsupportedOperationException();
        }

        this.accounts.put(acc.getExternalNo(), acc);
    }

    public Iterable<Account> getAccounts() {
        return this.accounts.values();
    }

    @Override
    public void doTick(Date d) {
        this.currentDate = d;
        this.accounts.values().forEach(acc -> doTick(d));
        this.ops.forEach(o -> { if (o.isExecutable()) o.execute(this.getBankHandle()); });
    }

    @Override
    public void acceptVisitor(BankVisitor v) {
        v.visit(this);
    }

    private AccountFactory accountFactory = new AccountFactory() {
        @Override
        public Account newAccount(Owner o) {
            final Account acc = new AccountImpl(BankImpl.this, o, KirMediatorImpl.getInstance().newId());
            BankImpl.this.addAccount(acc);

            return acc;
        }

        @Override
        public SavingsAccount newSavingsAccount(Account acc) {
            return new SavingsAccountDecorator(acc);
        }
    };

    public AccountFactory getAccountFactory() {
        return this.accountFactory;
    }
}
