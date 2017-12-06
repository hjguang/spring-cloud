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

	public Customer getCustomerById(Integer id);
	
	public List<Customer> queryAll();
}
