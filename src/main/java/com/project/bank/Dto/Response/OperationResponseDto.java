package com.project.bank.Dto.Response;

import com.project.bank.Enum.AccountType;
import com.project.bank.Enum.OperationType;

import java.io.Serializable;

public class OperationResponseDto implements Serializable {
    private String id;
    private OperationType operation_type;
    private double mount;
    private String account;

    private AccountType account_type;

    public OperationResponseDto() {
    }

    public OperationResponseDto(String id, OperationType operation_type, double mount, String account, AccountType account_type) {
        this.id = id;
        this.operation_type = operation_type;
        this.mount = mount;
        this.account = account;
        this.account_type = account_type;
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

    public AccountType getAccount_type() {
        return account_type;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }
}