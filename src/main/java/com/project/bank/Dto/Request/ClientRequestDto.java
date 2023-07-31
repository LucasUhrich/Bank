package com.project.bank.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ClientRequestDto implements Serializable {
    private String name;
    private  String surname;
    private  String email;
    private  String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private  Date birth_date;
    private  String address;
    private  String phone;

    public ClientRequestDto(String name, String surname, String email, String password, Date birth_date, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
    }

    public ClientRequestDto() {
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
}