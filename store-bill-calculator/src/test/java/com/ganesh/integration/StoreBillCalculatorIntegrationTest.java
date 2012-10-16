package com.ganesh.integration;

import java.util.List;

import org.junit.Test;

import com.ganesh.domain.Customer;
import com.ganesh.domain.Item;
import com.ganesh.storebilling.StoreBillCalculator;


/*
 * Following is the goal of this program
 * 
 * On a retail website, the following discounts apply: 
 * 
 * 1. If the user is an employee of the store, he gets a 30% discount 
 * 2. If the user is an affiliate of the store, he gets a 10% discount 
 * 3. If the user has been a customer for over 2 years, he gets a 5% discount. 
 * 4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). 
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.  
 * 
 * 
 * Finds the net payable amount. 
 * 
 * 
 */
public class StoreBillCalculatorIntegrationTest {

	StoreBillCalculator storeBillCalculator;
	private Customer customer;
	private List<Item> items;
	
	@Test
	public void shouldCalculateTheBill(){
		storeBillCalculator.calculatePayableAmount(customer,items);
	}
	
	
	
}