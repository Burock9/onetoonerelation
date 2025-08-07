package com.example.onetoonerelation.model;

import jakarta.persistence.*;

@Entity
public class Desk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Desk() {}
	
	public Desk(String code, Employee employee) {
		this.code = code;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
