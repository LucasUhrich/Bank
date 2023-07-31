package com.project.bank.Dao.Request;

import java.io.Serializable;

public class Saving_AccoutDto implements Serializable {
    private  String account_number;
    private  double interest_rate;

    public Saving_AccoutDto(String account_number, double interest_rate) {
        this.account_number = account_number;
        this.interest_rate = interest_rate;
    }

    public Saving_AccoutDto() {
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
}