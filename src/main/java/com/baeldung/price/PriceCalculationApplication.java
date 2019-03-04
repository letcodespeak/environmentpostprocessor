package com.baeldung.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.price.service.PriceCalculationService;

@SpringBootApplication
public class PriceCalculationApplication implements CommandLineRunner {

    @Autowired
    PriceCalculationService priceCalculationService;

    public static void main(String[] args) {
        SpringApplication.run(PriceCalculationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(priceCalculationService.productTotalPrice(10, 4));

    }

}
