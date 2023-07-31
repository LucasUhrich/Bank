package com.project.bank.Dao.Request;

import java.io.Serializable;

public class Current_AccoutDto implements Serializable {
    private  String account_number;

    public Current_AccoutDto(String account_number) {
        this.account_number = account_number;
    }

    public Current_AccoutDto() {
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}