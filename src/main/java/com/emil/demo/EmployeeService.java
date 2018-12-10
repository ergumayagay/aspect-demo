package com.emil.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee getEmployee(Integer id) {
		
		return employeeRepository.getOne(id);
	}
	
	
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
		return "Employee Saved";
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
}
