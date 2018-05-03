package com.hsbc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.demo.exception.GenericException;
import com.hsbc.demo.model.Employee;
import com.hsbc.demo.model.Salary;
import com.hsbc.demo.service.EmployeeService;

@RestController
@RequestMapping("v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "employees/{id}/salary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Salary> getEmployeeSalary(
			@PathVariable("id") long empId) throws GenericException {
		return new ResponseEntity<>(employeeService.getEmployeeSalary(empId),
				HttpStatus.OK);
	}

	@RequestMapping(value = "employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") long empId)
			throws GenericException {
		return new ResponseEntity<>(employeeService.getEmployee(empId),
				HttpStatus.OK);
	}

}
