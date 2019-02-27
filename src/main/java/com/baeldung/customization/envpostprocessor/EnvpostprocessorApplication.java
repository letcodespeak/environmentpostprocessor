package com.baeldung.customization.envpostprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.basket.calculation.PriceCalculator;

@SpringBootApplication
public class EnvpostprocessorApplication {

	
	@Autowired
	PriceCalculator priceCalculator;
	
	public static void main(String[] args) {
		SpringApplication.run(EnvpostprocessorApplication.class, args);
	}

}
