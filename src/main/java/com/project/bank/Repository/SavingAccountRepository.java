package com.project.bank.Repository;

import com.project.bank.Entity.Saving_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingAccountRepository extends JpaRepository<Saving_Account,String> {

    List<Saving_Account> findByClient_id(String id);

}
