package com.baeldung.price.postprocessor;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;

public class PriceCalculationEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Resource path = new ClassPathResource("external.properties");

		try {
			PropertySource<?> propertySource = new ResourcePropertySource("externalprops", path);
			environment.getPropertySources().addLast(propertySource);

		} catch (IOException e) {
			throw new IllegalStateException("Failed to load external configuration -  " + path, e);
		}

	}

}
