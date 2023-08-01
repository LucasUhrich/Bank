package com.project.bank.Entity;

import com.project.bank.Enum.AccountType;
import com.project.bank.Enum.OperationType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Operation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    private OperationType operation_type;

    private double mount;

    private String account;

    @Enumerated(EnumType.STRING)
    private AccountType account_type;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public Operation() {
    }

    public Operation(String id, OperationType operation_type, double mount, String account, Bank bank, Branch branch) {
        this.id = id;
        this.operation_type = operation_type;
        this.mount = mount;
        this.account = account;
        this.bank = bank;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperationType getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(OperationType operation_type) {
        this.operation_type = operation_type;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
