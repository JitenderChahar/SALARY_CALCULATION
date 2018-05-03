package com.hsbc.demo.model;

public class Salary {
	private long empId;
	private double preTax;
	private Tax taxes;
	private double postTax;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public double getPreTax() {
		return preTax;
	}

	public void setPreTax(double preTax) {
		this.preTax = preTax;
	}

	public Tax getTaxes() {
		return taxes;
	}

	public void setTaxes(Tax taxes) {
		this.taxes = taxes;
	}

	public double getPostTax() {
		return postTax;
	}

	public void setPostTax(double postTax) {
		this.postTax = postTax;
	}

}
