package com.ganesh.storebilling;

import java.util.List;

import com.ganesh.domain.Customer;
import com.ganesh.domain.CustomerType;
import com.ganesh.domain.Item;

public class StoreBillingCalculatorImpl implements StoreBillCalculator {

	private static final int DISCOUNT_PER_HUNDRED_BILL = 5;

	@Override
	public double calculatePayableAmount(Customer customer, List<Item> items) {
		double totalCost = 0.0;
		double discountedCost = 0.0;
		for (Item item : items) {
			discountedCost = discountedCost + calculateDiscountedCostForItem(customer, item);
			totalCost = totalCost + item.getCost();
		}

		double discountBasedOntotalCost = getDiscountBasedOntotalCost(totalCost);

		return discountedCost - discountBasedOntotalCost;
	}

	protected double calculateDiscountedCostForItem(Customer customer, Item item) {
		if (isCustomerEligibleForAnyDiscount(customer)) {
			return item.getPayableAmountAfterDiscount(customer.getType().getDiscountPercApplicatble());
		} else {
			return item.getCost();
		}
	}

	private boolean isCustomerEligibleForAnyDiscount(Customer customer) {
		return (customer.getType() == CustomerType.REGISTRED && customer.isEligibleForDiscount())
				|| customer.getType() != CustomerType.REGISTRED;
	}

	private double getDiscountBasedOntotalCost(double totalCost) {
		return Math.floor(totalCost / 100) * DISCOUNT_PER_HUNDRED_BILL;
	}

}
