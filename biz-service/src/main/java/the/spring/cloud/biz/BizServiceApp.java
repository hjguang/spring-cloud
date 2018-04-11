package the.spring.cloud.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class BizServiceApp {
	
	private static final Logger logger = LoggerFactory.getLogger(BizServiceApp.class);

	public static void main(String[] args) {
		SpringApplication.run(BizServiceApp.class, args);
	}

	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private Registration registration;
	
	@RequestMapping("/hello/{user}")
	public String hello(@PathVariable("user") String user) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/ host:" + instance.getHost() + ", port: " + instance.getPort() + ", service_id:"
				+ instance.getServiceId() + ", user:" + user);
//		List<ServiceInstance> list = client.getInstances(registration.getServiceId());
//		Gson gson = new Gson();
//		logger.info(gson.toJson(list));
		return "Hello " + user;
	}
}
