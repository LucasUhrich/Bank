package com.project.bank.Repository;

import com.project.bank.Entity.Current_Accout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentAccountRepository extends JpaRepository<Current_Accout,String> {
}
