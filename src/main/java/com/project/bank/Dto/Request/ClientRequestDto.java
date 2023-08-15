package com.project.bank.Dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class ClientRequestDto implements Serializable {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "Invalid name, minimum 2 characters, maximum 30")
    private String name;

    @NotBlank(message = "Surname cannot be null")
    @Size(min = 2, max = 30, message = "Invalid surname, minimum 2 characters, maximum 30")
    private String surname;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password cannot be null")
    @Size(min = 6, max = 30, message = "Invalid password, minimum 6 characters, maximum 30")
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth_date;

    @NotBlank(message = "Address cannot be null")
    @Size(min = 5, max = 50, message = "Invalid address, minium 5 characters ,maximum 50 characters")
    private String address;

    @NotBlank(message = "Phone cannot be null")
    @Size(max = 10, message = "Invalid phone number, maximum 10 characters")
    private String phone;


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