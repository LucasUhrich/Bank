package com.project.bank.Repository;

import com.project.bank.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String> {

    List<Branch> findByBank_name(String bankName);

}
