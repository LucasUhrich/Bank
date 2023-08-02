package com.project.bank.Dto.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class SavingAccountRequestDto implements Serializable {
    @NotBlank(message = "Interest rate cannot be null")
    @Size(max = 100, message = "Max rate 100")
    private double interest_rate;

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