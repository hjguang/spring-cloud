package org.zkclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ZkClientApp {
	@Value("${spring.application.name:zkserver}")
	private String appName;

	@Bean
	@LoadBalanced
	RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private RestTemplate rt;

	@RequestMapping("/user")
	public String getUser() {
		@SuppressWarnings("unchecked")
		Map<String, Object> user = rt.getForObject("http://" + this.appName + "/user", Map.class);
		return user.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(ZkClientApp.class, args);
	}
}
