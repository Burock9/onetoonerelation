package com.example.onetoonerelation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.onetoonerelation.model.Employee;
import com.example.onetoonerelation.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees () {
		return employeeRepository.findAll();
	} 
	
	public Optional<Employee> getEmployeeById (Long id) {
		return employeeRepository.findById(id);
	}
	
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			Employee employee = optionalEmployee.get();
			employee.setName(updatedEmployee.getName());
			return employeeRepository.save(employee);
		}
		return null;
	}
	
	public void deleteEmployee (Long id) {
		employeeRepository.deleteById(id);
	}
}
