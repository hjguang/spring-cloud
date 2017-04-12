package org.eureka.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApp {
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Value("${eureka.server.name}")
	private String eurekaServer;
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/{user}")
	public String hello(@PathVariable("user") String user) {
		return restTemplate.getForEntity("http://" +eurekaServer +"/hello/"+ user, String.class).getBody();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp.class, args);
	}
}
