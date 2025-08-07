package com.example.onetoonerelation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onetoonerelation.model.Employee;
import com.example.onetoonerelation.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEntity(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		return ResponseEntity.ok(employeeService.updateEmployee(id, updatedEmployee));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
	
}

