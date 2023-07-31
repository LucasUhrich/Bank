package com.project.bank.Dto.Request;

import java.io.Serializable;

public class SavingAccountRequestDto implements Serializable {
    private  String account_number;
    private  double interest_rate;

    public SavingAccountRequestDto(String account_number, double interest_rate) {
        this.account_number = account_number;
        this.interest_rate = interest_rate;
    }

    public SavingAccountRequestDto() {
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