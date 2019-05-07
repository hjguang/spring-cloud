/**
 * 
 */
package the.spring.cloud.customer.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import the.spring.cloud.customer.model.Customer;
import the.spring.cloud.customer.service.CustomerService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author houjianguang
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	public static List<Customer> customerList;
	static {
		//初始化数据
		String jsonStr = "[{\"customerId\":100,\"customerName\":\"Tom\"},{\"customerId\":101,\"customerName\":\"Welson\"}]";
		Type type = new TypeToken<List<Customer>>(){}.getType();
		customerList = new Gson().fromJson (jsonStr, type);
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerList.stream()
				.filter(customer -> id != null && id.intValue() == customer.getCustomerId())
				.findFirst()
				.orElse(null);
	}

	@HystrixCommand(fallbackMethod = "queryDefaultFallback",
			commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
	@Override
	public List<Customer> queryAll() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	/**
	 * 超时的默认回调
	 */
	public List<Customer> queryDefaultFallback() {
		return new ArrayList<>();
	}
}
