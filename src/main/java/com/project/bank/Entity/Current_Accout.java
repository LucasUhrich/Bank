package com.project.bank.Entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Current_Accout extends Account {
    public Current_Accout(String id, String account_number, double balance, Date opening_date, Branch branch, Client client) {
        super(id, account_number, balance, opening_date, branch, client);
    }

    public Current_Accout() {
    }
}
