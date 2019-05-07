/**
 * 
 */
package the.spring.cloud.customer.service;

import java.util.List;

import the.spring.cloud.customer.model.Customer;

/**
 * 客户查询接口
 * @author houjianguang
 *
 */
public interface CustomerService {

	Customer getCustomerById(Integer id);
	
	List<Customer> queryAll();
}
