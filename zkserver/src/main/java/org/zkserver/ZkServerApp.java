package org.zkserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
public class ZkServerApp {

	@RequestMapping("/user")
	public Map<String,Object> info() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "john");
		map.put("age", 22);
		return map;
	}
	public static void main(String[] args) {
		SpringApplication.run(ZkServerApp.class, args);
	}
}
