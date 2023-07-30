package com.project.bank.Dao.Request;

import java.io.Serializable;

public class Saving_AccoutDto implements Serializable {
    private final String account_number;
    private final double interest_rate;

    public Saving_AccoutDto(String account_number, double interest_rate) {
        this.account_number = account_number;
        this.interest_rate = interest_rate;
    }

    public String getAccount_number() {
        return account_number;
    }

    public double getInterest_rate() {
        return interest_rate;
    }
}