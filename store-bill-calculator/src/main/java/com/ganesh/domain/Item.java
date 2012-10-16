package com.ganesh.domain;

public class Item {
	
	private Product product;
	
	private double cost;

	public Item(Product product, double cost) {
		this.product = product;
		this.cost = cost;
	}

	public Product getProduct() {
		return product;
	}

	public double getCost() {
		return cost;
	}


	public double getPayableAmountAfterDiscount(double percentage) {
		if(product.isDiscountable()){
			return cost - (cost * percentage /100);
		}
		return cost;

	}
	
}
