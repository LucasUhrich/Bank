package com.project.bank.Repository;

import com.project.bank.Entity.Current_Account;
import com.project.bank.Entity.Saving_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavingAccountRepository extends JpaRepository<Saving_Account,String> {

    List<Saving_Account> findByClient_id(String id);

    @Query("SELECT c FROM Saving_Account c WHERE c.account_number = :number")
    Saving_Account findByAccount_number(@Param("number") String accountNumber);

}
