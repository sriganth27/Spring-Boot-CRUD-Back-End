package com.backend.service.impl;
import com.backend.exception.ResourceNotFoundException;
import com.backend.model.Employee;
import com.backend.respository.EmployeeRepository;
import com.backend.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	public EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		return employeeRepository.findById(id).orElseThrow(() -> 
		                           new ResourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether the employee id is existing in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
		
		                                        new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
				
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.findById(id).orElseThrow(() ->
		                                      new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
		
		
		
	}
	
	

}
