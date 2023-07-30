package com.project.bank.Entity;

import com.project.bank.Enum.JobTitle;
import com.project.bank.Enum.Rol;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee extends User{

    @Temporal(TemporalType.TIMESTAMP)
    private Date birth_date;

    @Enumerated(EnumType.STRING)
    private JobTitle cargo;

    public Employee(String id, String name, String surname, String email, String password, Date birth_date, String address, String phone, Rol rol, boolean active, Date registration, Branch branch, Date birth_date1, JobTitle cargo) {
        super(id, name, surname, email, password, birth_date, address, phone, rol, active, registration, branch);
        this.birth_date = birth_date1;
        this.cargo = cargo;
    }

    public Employee() {
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public JobTitle getCargo() {
        return cargo;
    }

    public void setCargo(JobTitle cargo) {
        this.cargo = cargo;
    }
}
