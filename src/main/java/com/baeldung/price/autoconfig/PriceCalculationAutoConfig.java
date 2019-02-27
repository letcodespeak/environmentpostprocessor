package com.baeldung.price.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import  org.springframework.core.Ordered;

import com.baeldung.price.calculation.GrossPriceCalculator;
import com.baeldung.price.calculation.NetPriceCalculator;
import com.baeldung.price.calculation.PriceCalculator;

@Configuration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE) 
public class PriceCalculationAutoConfig {
	
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
