/**
 * 
 */
package the.spring.cloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author houjianguang
 *
 */
@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class TurbineApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TurbineApp.class, args);

	}

}
