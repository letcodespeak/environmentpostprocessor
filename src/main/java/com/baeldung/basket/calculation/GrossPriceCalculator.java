package com.baeldung.basket.calculation;

import org.springframework.beans.factory.annotation.Value;

public class GrossPriceCalculator implements PriceCalculator {
	
	@Value("${com.baeldung.ecommerce.basket.cal.tax.rate}")
	double taxRate;
	

	@Override
	public double calculate(double singlePrice, int quantity) {
		double netPrice = singlePrice * quantity;
		return netPrice * ( 1 + taxRate);
	}

}
