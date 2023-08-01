package com.project.bank.Repository;

import com.project.bank.Entity.Account;
import com.project.bank.Entity.Current_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentAccountRepository extends JpaRepository<Current_Account,String> {

    List<Current_Account> findByClient_id(String id);

    @Query("SELECT c FROM Current_Account c WHERE c.account_number = :number")
    Current_Account findByAccount_number(@Param("number") String accountNumber);

}
