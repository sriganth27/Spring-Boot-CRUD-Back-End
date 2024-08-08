package com.backend.service;

import com.backend.model.Employee;
import java.util.*;
public interface EmployeeService {

	Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
   
	Employee getEmployeeById(long employeeId);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
	
	
}
