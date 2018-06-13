package com.guls.cashavail.adjustment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.guls.cashavail.ribbon.config.RibbonConfig;

/**
 * 
 * @author guls<br/>
 *         To be specific with Eureka discovery only. we could have also @EnableEurekaClient
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "variance-service", configuration = RibbonConfig.class)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
