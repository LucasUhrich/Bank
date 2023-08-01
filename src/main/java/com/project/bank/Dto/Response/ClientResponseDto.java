package com.project.bank.Dto.Response;

import com.project.bank.Enum.Rol;
import java.io.Serializable;
import java.util.Date;

public class ClientResponseDto implements Serializable {
    private  String id;
    private  String name;
    private  String surname;
    private  Rol rol;

    private boolean active;

    public ClientResponseDto() {
    }

    public ClientResponseDto(String id, String name, String surname, Rol rol, boolean active) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}