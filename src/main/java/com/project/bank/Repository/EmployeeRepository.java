package com.project.bank.Repository;

import com.project.bank.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    Employee findByEmail(String email);

    List<Employee> findByBranch_id(String id);

}
