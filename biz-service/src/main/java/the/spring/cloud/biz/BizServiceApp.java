package the.spring.cloud.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDiscoveryClient
@SpringBootApplication
//@RestController
//@EnableCircuitBreaker
public class BizServiceApp {

    private static final Logger logger = LoggerFactory.getLogger(BizServiceApp.class);

    public static void main(String[] args) {
        SpringApplication.run(BizServiceApp.class, args);
    }

//	@Autowired
//	private DiscoveryClient client;
//
//	@Autowired
//	private Registration registration;

//	@RequestMapping("/hello/{user}")
//	public String hello(@PathVariable("user") String user) {
//		ServiceInstance instance = client.getLocalServiceInstance();
//		logger.info("/ host:" + instance.getHost() + ", port: " + instance.getPort() + ", service_id:"
//				+ instance.getServiceId() + ", user:" + user);
////		List<ServiceInstance> list = client.getInstances(registration.getServiceId());
////		Gson gson = new Gson();
////		logger.info(gson.toJson(list));
//		return "Hello " + user;
//	}
}
