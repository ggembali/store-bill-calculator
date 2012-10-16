package com.ganesh.test.base;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.ganesh.domain.Customer;
import com.ganesh.domain.CustomerType;
import com.ganesh.domain.Item;
import com.ganesh.domain.Product;

public class BillCalculatorObjectMother {

	public static Item getSampleDisountableItem() {
		return new Item(getSampleDiscountableProduct(),200.00);
	}

	public static Item getSampleNonDisountableItem() {
		return new Item(getSampleNonDiscountableProduct(),200.00);
	}

	private static Product getSampleDiscountableProduct() {
		return new Product("iPhone", true);
	}

	private static Product getSampleNonDiscountableProduct() {
		return new Product("Sambar Masala", false);
	}
	
	public static List<Item> getItemsList(){
		return Arrays.asList(getSampleDisountableItem(),getSampleNonDisountableItem());
	}

	public static Customer getDiscountEligibleCustomer() {
		return new Customer("Ganesh", new Date(new Date().getYear() - 3, 1, 24), CustomerType.REGISTRED);
	}

	public static Customer getDiscountInEligibleCustomer() {
		return new Customer("Ganesh", new Date(new Date().getYear() - 1, 1, 24), CustomerType.REGISTRED);
	}
	
	public static Customer getEmployeeCustomer() {
		return new Customer("Ganesh", new Date(2009, 1, 24), CustomerType.EMPLOYEE);
	}

	public static Customer getAffiliateCustomer() {
		return new Customer("Ganesh", new Date(2009, 1, 24), CustomerType.AFFILIATE);
	}

}
