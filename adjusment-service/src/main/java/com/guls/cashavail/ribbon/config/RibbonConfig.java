package com.guls.cashavail.ribbon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

@Configuration
public class RibbonConfig {
	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	/**
	 * @author guls Spend a lot of time with <br/>
	 *         com.netflix.loadbalancer.RoundRobinRule : No up servers available
	 *         from load balancer: * com.netflix.client.ClientException: Load
	 *         balancer does not have available server for client:
	 *         variance-service.<br/>
	 *         If you start eureka locally and enable eureka for ribbon then
	 *         WeightedResponseTimeRule, AvailabilityFilteringRule wont work. You
	 *         will have to default it to ZoneAvoidanceRule
	 */
	@Bean
	public IRule ribbonRule(IClientConfig config) {

		// return new WeightedResponseTimeRule();
		// return new AvailabilityFilteringRule();
		return new ZoneAvoidanceRule();
	}
}
