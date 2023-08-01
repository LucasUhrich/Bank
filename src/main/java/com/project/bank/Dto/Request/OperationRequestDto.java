package com.project.bank.Dto.Request;

import com.project.bank.Enum.AccountType;

import java.io.Serializable;


public class OperationRequestDto implements Serializable {
    private double mount;
    private String account;

    private AccountType account_type;

    public OperationRequestDto() {
    }

    public OperationRequestDto(double mount, String account, AccountType account_type) {
        this.mount = mount;
        this.account = account;
        this.account_type = account_type;
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