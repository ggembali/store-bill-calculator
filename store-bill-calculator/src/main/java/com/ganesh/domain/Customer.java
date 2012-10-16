package com.ganesh.domain;

import java.util.Date;

public class Customer {
	private static final int DISOUNT_ELIGIBILITY_YEARS = 2;

	private String name;
	private Date registredOn;
	private CustomerType type;

	public Customer(String name, Date registredOn, CustomerType type) {
		super();
		this.name = name;
		this.registredOn = registredOn;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Date getRegistredOn() {
		return registredOn;
	}

	public CustomerType getType() {
		return type;
	}
	
	/*
	 * We could use jodatime libraries here for efficient calculation
	 */
	@SuppressWarnings("deprecation")
	public boolean isEligibleForDiscount(){
		Date today = new Date();
		
		return (today.getYear() - registredOn.getYear() > DISOUNT_ELIGIBILITY_YEARS) //Years already more than 2 
		|| (today.getYear() - registredOn.getYear() == DISOUNT_ELIGIBILITY_YEARS && today.getMonth() > registredOn.getMonth()) // year equal but month greater
		|| (today.getYear() - registredOn.getYear() == DISOUNT_ELIGIBILITY_YEARS && today.getMonth() == registredOn.getMonth() && today.getDate() >= registredOn.getDate()); 
	}

}

