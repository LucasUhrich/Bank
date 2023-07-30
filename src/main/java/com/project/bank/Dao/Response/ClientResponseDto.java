package com.project.bank.Dao.Response;

import com.project.bank.Enum.Rol;
import java.io.Serializable;
import java.util.Date;

public class ClientResponseDto implements Serializable {
    private final String id;
    private final String name;
    private final String surname;
    private final Rol rol;
    private final Date registration;

    public ClientResponseDto(String id, String name, String surname, Rol rol, Date registration) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.registration = registration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Rol getRol() {
        return rol;
    }

    public Date getRegistration() {
        return registration;
    }
}