package com.ganesh.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ganesh.test.base.BillCalculatorObjectMother;

public class ItemTest {

	@Test
	public void shouldSellIPhonesAtDiscount() {
		Item item = BillCalculatorObjectMother.getSampleDisountableItem();
		assertEquals(180.0, item.getPayableAmountAfterDiscount(10),0.0);
	}

	@Test
	public void shouldNotApplyDiscountForSambarMasala() {
		Item item = BillCalculatorObjectMother.getSampleNonDisountableItem();
		assertEquals(200.0, item.getPayableAmountAfterDiscount(10),0.0);
	}

}
