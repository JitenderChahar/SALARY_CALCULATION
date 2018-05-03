package com.hsbc.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.hsbc.demo.constant.Constants;
import com.hsbc.demo.exception.DataNotFoundException;
import com.hsbc.demo.exception.GenericException;
import com.hsbc.demo.model.Employee;
import com.hsbc.demo.model.Salary;
import com.hsbc.demo.model.Tax;
import com.hsbc.demo.utils.TaxCalculator;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private Map<Long, Employee> employeesRepo = new HashMap<>();
	private Map<String, Double> stateTaxes = new HashMap<>();

	public EmployeeServiceImpl() {
		stateTaxes.put(Constants.CA, Constants.CA_TAX);
		stateTaxes.put(Constants.CO, Constants.CO_TAX);

		Employee employee1 = new Employee(1, "Sam", "Software Developer", "IT",
				"CA");
		Employee employee2 = new Employee(2, "John",
				"Senior Software Developer", "IT", "CO");
		Employee employee3 = new Employee(3, "Mary", "Project manager", "IT",
				"CO");
		Employee employee4 = new Employee(4, "Miller", "Human Resource", "HR",
				"CA");

		employeesRepo.put(1L, employee1);
		employeesRepo.put(2L, employee2);
		employeesRepo.put(3L, employee3);
		employeesRepo.put(4L, employee4);
	}

	@Override
	public Salary getEmployeeSalary(long empId) throws GenericException {
		Employee employee = employeesRepo.get(empId);
		checkForData(employee);

		// calculate federal tax
		double federalTax = TaxCalculator.calculateTax(
				Constants.PRE_TAX_SALARY, Constants.FEREDEAL_TAX);
		double salaryPreStateTax = TaxCalculator.salaryPostTax(
				Constants.PRE_TAX_SALARY, federalTax);

		String state = employee.getState();
		Double stateTaxPct = stateTaxes.get(state);
		double stateTax = TaxCalculator.calculateTax(salaryPreStateTax,
				stateTaxPct);

		Salary sal = new Salary();
		sal.setEmpId(empId);
		sal.setPreTax(Constants.PRE_TAX_SALARY);
		sal.setPostTax(TaxCalculator.salaryPostTax(salaryPreStateTax, stateTax));
		Tax tax = new Tax(stateTax, federalTax);
		sal.setTaxes(tax);

		return sal;
	}

	private void checkForData(Object object) throws DataNotFoundException {
		if (object == null) {
			throw new DataNotFoundException(Constants.EMPLOYEE_DATA_NOT_FOUND);
		}
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<>();
		for (Entry<Long, Employee> entry : employeesRepo.entrySet()) {
			employees.add(entry.getValue());
		}
		return employees;
	}

	@Override
	public Employee getEmployee(long empId) throws GenericException {
		Employee employee = employeesRepo.get(empId);
		checkForData(employee);
		return employee;
	}

}
