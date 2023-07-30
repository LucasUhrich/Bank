package com.project.bank.Dao.Request;

import java.io.Serializable;
import java.util.Date;

public class ClientRequestDto implements Serializable {
    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final Date birth_date;
    private final String address;
    private final String phone;

    public ClientRequestDto(String name, String surname, String email, String password, Date birth_date, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
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
}