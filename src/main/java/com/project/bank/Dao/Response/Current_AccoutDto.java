package com.project.bank.Dao.Response;

import java.io.Serializable;
import java.util.Date;

public class Current_AccoutDto implements Serializable {
    private  String id;
    private  String account_number;
    private  double balance;
    private  Date opening_date;

    public Current_AccoutDto(String id, String account_number, double balance, Date opening_date) {
        this.id = id;
        this.account_number = account_number;
        this.balance = balance;
        this.opening_date = opening_date;
    }

    public Current_AccoutDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public void setOpening_date(Date opening_date) {
        this.opening_date = opening_date;
    }
}