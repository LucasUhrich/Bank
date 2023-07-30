package com.project.bank.Entity;

import com.project.bank.Enum.Rol;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Client extends User{

    public Client() {
        super();
    }

    public Client(String id, String name, String surname, String email, String password, Date birth_date, String address, String phone, Rol rol, boolean active, Date registration, Branch branch) {
        super(id, name, surname, email, password, birth_date, address, phone, rol, active, registration, branch);
    }
}
