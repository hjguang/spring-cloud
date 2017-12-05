package the.spring.cloud.service.apigatway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@CrossOrigin
@EnableSwagger2 
@EnableCircuitBreaker
public class BizServiceApiGateway {
	
	@Bean
	  public AlwaysSampler defaultSampler() {
	    return new AlwaysSampler();
	}

	@Bean
	public CustomZuulFilter customFilter() {
		return new CustomZuulFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BizServiceApiGateway.class, args);
	}
	
}

@RestController 
class ApiGatewayController {

	@RequestMapping("/")
	String home(HttpServletRequest req){
		return "<H1>Zuul API Gateway Home!</H1>"; 
	}
}

@RestController
class BizApiGatewayController {
	private static final Logger logger = LoggerFactory.getLogger(BizApiGatewayController.class);
	
	@Autowired
	BizAPIGatewayComponent component;
	
	@RequestMapping("/getBook")
	String getHub(Integer id, HttpServletRequest request){
		logger.info("获取书籍信息,跳转到biz-service微服务中,参数:{}", id);
		return component.getBook(id); 
	} 
}

@Component	
class BizAPIGatewayComponent { 
	
	private static final Logger logger = LoggerFactory.getLogger(BizAPIGatewayComponent.class);
	
 	@Autowired 
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getDefaultInfo")
	public String getBook(Integer id){
		String result = restTemplate.getForObject("http://biz-service/book/" + id, String.class);
		logger.info("{}", result);
		return result;
	}
	public String getDefaultInfo(Integer id){
		return "The Default Book Info";
	}
}

@Configuration
class AppConfiguration {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}	
