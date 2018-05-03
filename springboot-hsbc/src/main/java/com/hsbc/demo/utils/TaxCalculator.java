package com.hsbc.demo.utils;

public class TaxCalculator {
	public static double calculateTax(double preTaxSal, double taxPct) {
		return preTaxSal * (taxPct / 100);
	}

	public static double salaryPostTax(double salary, double tax) {
		return salary - tax;
	}
}
