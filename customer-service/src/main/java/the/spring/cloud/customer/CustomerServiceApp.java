/**
 * 
 */
package the.spring.cloud.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author houjianguang
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CustomerServiceApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApp.class, args);
	}
}

/**
 * 客户信息rest服务
 * @author houjianguang
 *
 */
@RestController
@RequestMapping("/customer")
class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	public static List<Map<String, Object>> customerList= new ArrayList<>();
	static {
		Map<String, Object> customer = new HashMap<>();
		customer.put("id", 1);
		customer.put("name", "Tom");
		customer.put("birthday", DateUtils.parseDate("1999-9-9", new String[]{"yyyy-MM-dd"}));
		customerList.add(customer);
	}
	
	@RequestMapping("/{id}")
	public ModelMap getCustomerById(@PathVariable("id") Integer id) {
		logger.info("查询客户id:{}", id);
		ModelMap mm = new ModelMap();
		for (Map<String, Object> customer : customerList) {
			if(id == ((Integer)customer.get("id")).intValue() ) {
				mm.addAttribute("customer", customer);
			}
		}
		
		return mm;
	}
	
	@RequestMapping("/queryAll")
	public List<?> queryAllCustomer() {
		return component.queryAllCustomer();
	}
	
	@Autowired
	CustomerComponent component;
}

@Component
class CustomerComponent {
	
	@HystrixCommand(fallbackMethod = "queryDefaultFallback")
	public List<?> queryAllCustomer() {
		return CustomerController.customerList;
	}
	
	public List<?> queryDefaultFallback() {
		return new ArrayList<>();
	}
}