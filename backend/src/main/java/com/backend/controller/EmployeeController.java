package com.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Employee;
import com.backend.service.EmployeeService;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping()
    public List<Employee> getAllEmployees(){
    	return employeeService.getAllEmployee();
    	
    }
    
    //build get employee by id rest api
    //http://localhost:8081/api/employee/12
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
    	return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    	
    }
    
    //build update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId , 
    		                                        @RequestBody Employee employee ){
    	
    	return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    	
    }
    
    //build delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmploye(@PathVariable("id") long id){
    	
    	employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted succesfully!.", HttpStatus.OK);
    	
    }
}
