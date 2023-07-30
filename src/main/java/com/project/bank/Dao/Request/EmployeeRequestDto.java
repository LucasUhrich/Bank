package com.project.bank.Dao.Request;

import com.project.bank.Enum.JobTitle;

import java.io.Serializable;
import java.util.Date;

public class EmployeeRequestDto implements Serializable {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Date birth_date;
    private final String address;
    private final String phone;
    private final Date registration;
    private final JobTitle cargo;

    public EmployeeRequestDto(String name, String surname, String email, String password, Date birth_date, String address, String phone, Date registration, JobTitle cargo) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
        this.registration = registration;
        this.cargo = cargo;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Date getRegistration() {
        return registration;
    }

    public JobTitle getCargo() {
        return cargo;
    }
}