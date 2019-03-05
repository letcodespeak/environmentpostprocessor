package com.baeldung.price;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.price.service.PriceCalculationService;

//-Dspring-boot.run.arguments="argOne,argTwo"

@SpringBootApplication
public class PriceCalculationApplication implements CommandLineRunner {

    @Autowired
    PriceCalculationService priceCalculationService;

    public static void main(String[] args) {
        SpringApplication.run(PriceCalculationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    	List<String> params = Arrays.stream(args).collect(Collectors.toList());
   	    double singlePrice = Double.valueOf(params.get(0));
   	    int quantity = Integer.valueOf(params.get(1));
   	    priceCalculationService.productTotalPrice(singlePrice, quantity);
    }

}
