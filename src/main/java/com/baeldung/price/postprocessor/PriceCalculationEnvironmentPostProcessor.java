package com.baeldung.price.postprocessor;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;

public class PriceCalculationEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

    /**
     * The default order for the processor.
     */
    public static final int DEFAULT_ORDER = Ordered.LOWEST_PRECEDENCE;

    private int order = DEFAULT_ORDER;

    private static final String PROPERTY_PREFIX = "com.baeldung.ecommerce.";

    private static final String OS_ENV_PROPERTY_CALCUATION_MODE = "calculation_mode";
    private static final String OS_ENV_PROPERTY_GROSS_CALCULATION_TAX_RATE = "gross_calculation_tax_rate";

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        PropertySource<?> systemEnvironmentPropertySource = environment.getPropertySources()
            .get(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME);

        if (isActive(systemEnvironmentPropertySource)) {
            Map<String, Object> priceCalculationConfiguration = new LinkedHashMap<>();
            priceCalculationConfiguration.put(key(OS_ENV_PROPERTY_CALCUATION_MODE), systemEnvironmentPropertySource.getProperty(OS_ENV_PROPERTY_CALCUATION_MODE));
            priceCalculationConfiguration.put(key(OS_ENV_PROPERTY_GROSS_CALCULATION_TAX_RATE), systemEnvironmentPropertySource.getProperty(OS_ENV_PROPERTY_GROSS_CALCULATION_TAX_RATE));
            PropertySource<?> priceCalcuationPropertySource = new MapPropertySource("priceCalcuationPS", priceCalculationConfiguration);
            environment.getPropertySources()
                .addAfter(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, priceCalcuationPropertySource);
        } else {
            throw new IllegalStateException("Required system environment properties not found!");
        }

    }

    private String key(String key) {
        return PROPERTY_PREFIX + key.replaceAll("\\_", ".");
    }

    private boolean isActive(PropertySource<?> systemEnvpropertySource) {
        if (systemEnvpropertySource.containsProperty(OS_ENV_PROPERTY_CALCUATION_MODE) && systemEnvpropertySource.containsProperty(OS_ENV_PROPERTY_GROSS_CALCULATION_TAX_RATE)) {
            return true;
        } else
            return false;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

}
