/**
 *
 */
package the.spring.cloud.customer;

import java.util.*;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableCircuitBreaker
public class CustomerServiceApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApp.class, args);
    }
}
