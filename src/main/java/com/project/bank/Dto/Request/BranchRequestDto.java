package com.project.bank.Dto.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class BranchRequestDto implements Serializable {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "Invalid name, minimum 3 characters, maxium 30")
    private String country;
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "Invalid name, minimum 3 characters, maxium 30")
    private String province;
    @NotBlank(message = "Name cannot be null")
    @Size(min = 2, max = 30, message = "Invalid name, minimum 3 characters, maxium 30")
    private String city;

    public BranchRequestDto(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public BranchRequestDto() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}