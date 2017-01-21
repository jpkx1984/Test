package edu.bank;


import edu.bank.ops.Operation;

import java.util.HashMap;
import java.util.Map;

class ExampleReportVisitor implements BankVisitor {
    public HashMap<String, Integer> opsPerAccount = new HashMap<String, Integer>();
    @Override
    public void visit(BankVisitable v) {

    }

    @Override
    public void visit(Bank b) {

    }

    private String currentAcc = "";

    @Override
    public void visit(Account acc) {
        this.currentAcc = acc.getExternalNo();
    }

    @Override
    public void visit(Operation op) {
        if (!this.opsPerAccount.containsKey(this.currentAcc)) {
            this.opsPerAccount.put(this.currentAcc, 0);
        }

        int v = this.opsPerAccount.get(this.currentAcc);
        ++v;
        this.opsPerAccount.put(this.currentAcc, v);

    }
}


/**
 * Created by janusz on 11.12.16.
 */
public class ExampleReport implements Report<Map<String, Integer>> {
    private ExampleReportVisitor visitor = new ExampleReportVisitor();
    @Override
    public void build(Bank b) {
        this.visitor.visit(b);
    }

    public Map<String, Integer> getResult() {
        return this.visitor.opsPerAccount;
    }
}
