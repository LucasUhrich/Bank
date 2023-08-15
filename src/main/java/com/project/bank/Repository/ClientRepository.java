package com.project.bank.Repository;

import com.project.bank.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findByEmail(String email);

    List<Client> findByBranch_id(String id);

}
