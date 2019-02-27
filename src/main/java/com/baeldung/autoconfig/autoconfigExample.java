package com.baeldung.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import  org.springframework.core.Ordered;

import com.baeldung.basket.calculation.GrossPriceCalculator;
import com.baeldung.basket.calculation.NetPriceCalculator;
import com.baeldung.basket.calculation.PriceCalculator;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE) 
public class autoconfigExample {
	
	@Bean
	@ConditionalOnProperty(
	  name = "com.baeldung.ecommerce.basket.cal.mode", 
	  havingValue = "NET")
	@ConditionalOnMissingBean
	public PriceCalculator getNetPriceCalculator() {
		return new NetPriceCalculator();
		
	}

	
	@Bean
	@ConditionalOnProperty(
	  name = "com.baeldung.ecommerce.basket.cal.mode", 
	  havingValue = "GROSS")
	@ConditionalOnMissingBean
	public PriceCalculator getGrossPriceCalculator() {
		return new GrossPriceCalculator();
		
	}
	
}
