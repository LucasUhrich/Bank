package com.project.bank.Dao.Response;

import com.project.bank.Enum.JobTitle;
import com.project.bank.Enum.Rol;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private  String id;
    private  String name;
    private  String surname;
    private  Rol rol;
    private  boolean active;
    private  JobTitle cargo;

    public EmployeeDto(String id, String name, String surname, Rol rol, boolean active, JobTitle cargo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rol = rol;
        this.active = active;
        this.cargo = cargo;
    }

    public EmployeeDto() {
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

    public JobTitle getCargo() {
        return cargo;
    }

    public void setCargo(JobTitle cargo) {
        this.cargo = cargo;
    }
}