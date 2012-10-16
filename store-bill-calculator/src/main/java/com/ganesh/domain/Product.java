package com.ganesh.domain;

public class Product {
	private String name;
	private boolean discountable;
	
	public Product(String name, boolean discountable) {
		super();
		this.name = name;
		this.discountable = discountable;
	}


	public String getName() {
		return name;
	}

	public boolean isDiscountable() {
		return discountable;
	}
}
