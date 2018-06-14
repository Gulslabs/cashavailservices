package com.guls.cashavail.adjustment;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.guls.cashavail.adjustment")
public class ApplicationConfiguration {

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

}
