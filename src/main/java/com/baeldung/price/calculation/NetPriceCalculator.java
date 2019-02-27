package com.baeldung.price.calculation;

public class NetPriceCalculator implements PriceCalculator {

	@Override
	public double calculate(double singlePrice, int quantity) {
		// TODO Auto-generated method stub
		return singlePrice * quantity;
	}

}
