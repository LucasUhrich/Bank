package com.project.bank.Dto.Request;

import java.io.Serializable;

public class SavingAccountRequestDto implements Serializable {

    private  double interest_rate;

    public SavingAccountRequestDto() {
    }

    public SavingAccountRequestDto(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
}