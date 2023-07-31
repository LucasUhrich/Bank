package com.project.bank.Repository;

import com.project.bank.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {

    Branch findByCity(String city);

}
