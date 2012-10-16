package com.ganesh.domain;

/*
 * 
 * 
 */
public enum CustomerType {
	EMPLOYEE(30.0),AFFILIATE(20.0),REGISTRED(10.0);
	
	private CustomerType(double discount) {
		discountPercApplicatble = discount;
	}
	
	public double getDiscountPercApplicatble() {
		return discountPercApplicatble;
	}

	private double discountPercApplicatble;
}
