/**
 * 
 */
package the.spring.cloud.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import the.spring.cloud.client.feign.BizFeignClient;

/**
 * @author houjianguang
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class BizClientApp {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BizClientApp.class, args);
		
	}

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value = "/{user}")
	public String hello(@PathVariable("user") String user) {
		ResponseEntity<String> respEntity = restTemplate.getForEntity("http://biz-service-apigatway/api/hello/"+ user, String.class);
		return respEntity.getBody();
		
	}
	
	@Autowired
	BizFeignClient bizFeignClient;
	
	@RequestMapping("/goods/{id}")
	public String info(@PathVariable("id") Integer id) {
		
		return bizFeignClient.getGoodsInfo(id);
	}
}
