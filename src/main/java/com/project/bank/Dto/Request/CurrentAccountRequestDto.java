package com.project.bank.Dto.Request;

import java.io.Serializable;

public class CurrentAccountRequestDto implements Serializable {
    private  String account_number;

    public CurrentAccountRequestDto(String account_number) {
        this.account_number = account_number;
    }

    public CurrentAccountRequestDto() {
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}