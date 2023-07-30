package com.project.bank.Dao.Response;

import com.project.bank.Enum.JobTitle;
import com.project.bank.Enum.Rol;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private final String id;
    private final String name;
    private final String surname;
    private final Rol rol;
    private final boolean active;
    private final JobTitle cargo;

    public EmployeeDto(String id, String name, String surname, Rol rol, boolean active, JobTitle cargo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.active = active;
        this.cargo = cargo;
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

    public boolean getActive() {
        return active;
    }

    public JobTitle getCargo() {
        return cargo;
    }
}