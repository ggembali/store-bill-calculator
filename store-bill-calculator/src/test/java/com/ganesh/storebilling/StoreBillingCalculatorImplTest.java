package com.ganesh.storebilling;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ganesh.domain.Customer;
import com.ganesh.domain.Item;

import static com.ganesh.test.base.BillCalculatorObjectMother.*;

public class StoreBillingCalculatorImplTest {

	StoreBillingCalculatorImpl storeBillCalculator = new StoreBillingCalculatorImpl();
	
	@Before
	public void setup(){
		
	}
	
	@Test
	public void shouldNotDiscountForRegistredCustomer(){
		Customer discountInEligibleCustomer = getDiscountInEligibleCustomer();
		Item item = getSampleDisountableItem();
		double costForItem = storeBillCalculator.calculateDiscountedCostForItem(discountInEligibleCustomer, item);
		Assert.assertEquals(200, costForItem,0.0);
	}

	@Test
	public void shouldDiscountForRegistredCustomer(){
		Customer discountInEligibleCustomer = getDiscountEligibleCustomer();
		Item item = getSampleDisountableItem();
		double costForItem = storeBillCalculator.calculateDiscountedCostForItem(discountInEligibleCustomer, item);
		Assert.assertEquals(180, costForItem,0.0);
	}

	@Test
	public void shouldDiscountForEmployee(){
		Customer discountInEligibleCustomer = getEmployeeCustomer();
		Item item = getSampleDisountableItem();
		double costForItem = storeBillCalculator.calculateDiscountedCostForItem(discountInEligibleCustomer, item);
		Assert.assertEquals(140, costForItem,0.0);
	}

	@Test
	public void shouldDiscountForAffiliate(){
		Customer discountInEligibleCustomer = getAffiliateCustomer();
		Item item = getSampleDisountableItem();
		double costForItem = storeBillCalculator.calculateDiscountedCostForItem(discountInEligibleCustomer, item);
		Assert.assertEquals(160, costForItem,0.0);
	}
	
	@Test
	public void shouldCalculateTotalCostBasedDiscount(){
		Assert.assertEquals(40,storeBillCalculator.getDiscountBasedOntotalCost(800),0.0);
		Assert.assertEquals(40,storeBillCalculator.getDiscountBasedOntotalCost(890),0.0);
	}
	
}
