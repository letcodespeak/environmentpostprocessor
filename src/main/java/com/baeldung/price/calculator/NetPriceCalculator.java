package com.baeldung.price.calculator;

public class NetPriceCalculator implements PriceCalculator {
    @Override
    public double calculate(double singlePrice, int quantity) {
        return singlePrice * quantity;
    }
}
