package com.project.bank.Dao.Response;

import java.io.Serializable;
import java.util.Date;

public class Current_AccoutDto implements Serializable {
    private final String id;
    private final String account_number;
    private final double balance;
    private final Date opening_date;

    public Current_AccoutDto(String id, String account_number, double balance, Date opening_date) {
        this.id = id;
        this.account_number = account_number;
        this.balance = balance;
        this.opening_date = opening_date;
    }

    public String getId() {
        return id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public double getBalance() {
        return balance;
    }

    public Date getOpening_date() {
        return opening_date;
    }
}