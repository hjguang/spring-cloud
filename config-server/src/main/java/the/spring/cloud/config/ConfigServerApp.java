/**
 * 
 */
package the.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author houjianguang
 *
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApp.class, args);

	}

}
