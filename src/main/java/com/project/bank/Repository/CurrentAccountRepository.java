package com.project.bank.Repository;

import com.project.bank.Entity.Current_Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountRepository extends JpaRepository<Current_Account,String> {
}
