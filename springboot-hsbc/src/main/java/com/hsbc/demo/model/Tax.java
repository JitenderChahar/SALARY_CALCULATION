package com.hsbc.demo.model;

public class Tax {
	private double stateTax;
	private double federalTax;

	public Tax() {
	}

	public Tax(double stateTax, double federalTax) {
		this.stateTax = stateTax;
		this.federalTax = federalTax;
	}

	public double getStateTax() {
		return stateTax;
	}

	public void setStateTax(double stateTax) {
		this.stateTax = stateTax;
	}

	public double getFederalTax() {
		return federalTax;
	}

	public void setFederalTax(double federalTax) {
		this.federalTax = federalTax;
	}

}
