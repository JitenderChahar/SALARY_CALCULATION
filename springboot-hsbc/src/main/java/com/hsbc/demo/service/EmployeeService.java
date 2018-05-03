package com.hsbc.demo.service;

import java.util.List;

import com.hsbc.demo.exception.GenericException;
import com.hsbc.demo.model.Employee;
import com.hsbc.demo.model.Salary;

public interface EmployeeService {
	Salary getEmployeeSalary(long empId) throws GenericException;

	List<Employee> getEmployees();

	Employee getEmployee(long empId) throws GenericException;
}
