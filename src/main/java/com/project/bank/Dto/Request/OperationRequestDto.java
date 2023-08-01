package com.project.bank.Dto.Request;

import java.io.Serializable;


public class OperationRequestDto implements Serializable {
    private double mount;
    private String account;

    public OperationRequestDto() {
    }

    public OperationRequestDto(double mount, String account) {
        this.mount = mount;
        this.account = account;
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
}