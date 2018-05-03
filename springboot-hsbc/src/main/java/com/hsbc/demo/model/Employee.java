package com.hsbc.demo.model;

public class Employee {
	private long empId;
	private String name;
	private String designation;
	private String department;
	private String state;

	public Employee() {
	}

	public Employee(long empId, String name, String designation,
			String department, String state) {
		this.empId = empId;
		this.name = name;
		this.designation = designation;
		this.department = department;
		this.state = state;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
