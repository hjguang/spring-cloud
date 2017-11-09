package org.eureka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppServiceController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private DiscoveryClient client;

	@SuppressWarnings("deprecation")
	@RequestMapping("/hello/{user}")
	public String hello(@PathVariable("user") String user) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/add, host:" + instance.getHost() + ", port: " + instance.getPort() + ", service_id:"
				+ instance.getServiceId() + ", user:" + user);
		return "Hello " + user;
	}
}
