/**
 * 
 */
package the.spring.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author houjianguang
 *
 */
@SpringBootApplication
@RefreshScope
public class ConfigClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApp.class, args);
	}
}
