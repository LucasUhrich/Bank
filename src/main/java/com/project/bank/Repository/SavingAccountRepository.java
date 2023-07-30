package com.project.bank.Repository;

import com.project.bank.Entity.Saving_Accout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountRepository extends JpaRepository<Saving_Accout,String> {
}
