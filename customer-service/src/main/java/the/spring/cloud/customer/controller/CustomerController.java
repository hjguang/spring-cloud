/**
 * 
 */
package the.spring.cloud.customer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import the.spring.cloud.customer.model.Customer;
import the.spring.cloud.customer.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author houjianguang
 * 客户rest服务访问
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Integer id) {
		logger.info("查询客户id:{}", id);
		return customerService.getCustomerById(id);
	}

	@RequestMapping("/queryAll")
	public List<Customer> queryAllCustomer() {
		return customerService.queryAll();
	}
}


