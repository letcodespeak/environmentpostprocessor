package com.baeldung.price.postprocessor;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.price.service.PriceCalculationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceCalculationEnvironmentPostProcessorTest {
    
    
    @Autowired
    private PriceCalculationService priceCalculationService;
 
    @BeforeClass
    public static void setEnv() {
        //System.getenv().put("calculation_mode", "GROSS");
        //System.getenv().put("gross_calculation_tax_rate", "0.15");
        
        ProcessBuilder pb = new ProcessBuilder();
        Map<String, String> env = pb.environment();
        env.put("log_dir", "/tmp/log");
        Process process = pb.start();
        
    }

    @Test
    public void contextLoads() {
       assertThat(priceCalculationService.productTotalPrice(10, 4)).isEqualTo(40);  
    }

    

}
