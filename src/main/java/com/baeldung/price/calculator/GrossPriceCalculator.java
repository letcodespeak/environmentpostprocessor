package com.baeldung.price.calculator;

import org.springframework.beans.factory.annotation.Value;

public class GrossPriceCalculator implements PriceCalculator {

	@Value("${com.baeldung.ecommerce.gross.calculation.tax.rate}")
	double taxRate;

	@Override
	public double calculate(double singlePrice, int quantity) {
		double netPrice = singlePrice * quantity;
		return netPrice * (1 + taxRate);
	}

}
