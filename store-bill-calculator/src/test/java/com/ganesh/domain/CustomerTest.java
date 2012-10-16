package com.ganesh.domain;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class CustomerTest {

	@SuppressWarnings("deprecation")
	@Test
	public void registeredInYear2009ShouldBeEligible() {
		Date today = new Date();
		
		assertTrue("With year diff > 2",new Customer("Ganesh", new Date(today.getYear() - 2, today.getMonth() - 1 , today.getDate()), CustomerType.REGISTRED).isEligibleForDiscount());
		assertTrue("With same year but month >", new Customer("Ganesh", new Date(today.getYear() - 2, today.getMonth() - 1 , today.getDate()), CustomerType.REGISTRED).isEligibleForDiscount());
		assertTrue("With same year and month but date  >",new Customer("Ganesh", new Date(today.getYear() - 2, today.getMonth(), today.getDate()-2), CustomerType.REGISTRED).isEligibleForDiscount());

		assertTrue(!(new Customer("Ganesh", new Date(today.getYear() - 1 , today.getMonth() - 1 , today.getDate()), CustomerType.REGISTRED).isEligibleForDiscount()));

		//Exactly 2 years : Assuming eligible
		assertTrue(new Customer("Ganesh", new Date(today.getYear() - 2 , today.getMonth() , today.getDate()), CustomerType.REGISTRED).isEligibleForDiscount());
		
	}

}
