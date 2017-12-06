/**
 * 
 */
package the.spring.cloud.customer.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author houjianguang
 *
 */
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4789250553540012268L;

	private Integer customerId;
	private String customerName;
	private Date birthday;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
