package com.backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.backend.model.Employee;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
