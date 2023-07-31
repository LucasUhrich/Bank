package com.project.bank.Dao.Request;

import com.project.bank.Enum.JobTitle;

import java.io.Serializable;
import java.util.Date;

public class EmployeeRequestDto implements Serializable {
    private  String name;
    private  String surname;
    private  String email;
    private  String password;
    private  Date birth_date;
    private  String address;
    private  String phone;
    private  Date registration;
    private  JobTitle cargo;

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

    public EmployeeRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public JobTitle getCargo() {
        return cargo;
    }

    public void setCargo(JobTitle cargo) {
        this.cargo = cargo;
    }
}