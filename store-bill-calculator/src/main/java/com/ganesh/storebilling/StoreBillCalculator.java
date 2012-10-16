package com.ganesh.storebilling;

import java.util.List;

import com.ganesh.domain.Customer;
import com.ganesh.domain.Item;

public interface StoreBillCalculator {

	double calculatePayableAmount(Customer customer, List<Item> items);

}

