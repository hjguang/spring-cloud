package the.spring.cloud.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class BizServiceApp {
	
	private static final Logger logger = LoggerFactory.getLogger(BizServiceApp.class);

	public static void main(String[] args) {
		SpringApplication.run(BizServiceApp.class, args);
	}

	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping("/hello/{user}")
	public String hello(@PathVariable("user") String user) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/ host:" + instance.getHost() + ", port: " + instance.getPort() + ", service_id:"
				+ instance.getServiceId() + ", user:" + user);
		return "Hello " + user;
	}
}
