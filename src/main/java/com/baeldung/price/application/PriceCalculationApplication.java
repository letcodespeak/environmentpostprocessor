package com.baeldung.price.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.price.calculator.PriceCalculator;

@SpringBootApplication
public class PriceCalculationApplication implements CommandLineRunner {

    @Autowired
    PriceCalculator priceCalculator;

    public static void main(String[] args) {
        SpringApplication.run(PriceCalculationApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(priceCalculator.calculate(10, 4));

    }

}
