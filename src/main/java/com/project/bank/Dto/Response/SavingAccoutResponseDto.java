package com.project.bank.Dto.Response;

import java.io.Serializable;
import java.util.Date;

public class SavingAccoutResponseDto implements Serializable {
    private  String id;
    private  String account_number;
    private  double balance;
    private  Date opening_date;
    private  double interest_rate;

    public SavingAccoutResponseDto(String id, String account_number, double balance, Date opening_date, double interest_rate) {
        this.id = id;
        this.account_number = account_number;
        this.balance = balance;
        this.opening_date = opening_date;
        this.interest_rate = interest_rate;
    }

    public SavingAccoutResponseDto() {
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

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
}