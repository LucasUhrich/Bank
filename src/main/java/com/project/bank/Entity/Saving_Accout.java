package com.project.bank.Entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Saving_Accout extends Account {

    private double interest_rate;

    public Saving_Accout() {
    }

    public Saving_Accout(String id, String account_number, double balance, Date opening_date, Branch branch, Client client, double interest_rate) {
        super(id, account_number, balance, opening_date, branch, client);
        this.interest_rate = interest_rate;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
}
