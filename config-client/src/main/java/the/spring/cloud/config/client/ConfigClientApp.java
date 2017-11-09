/**
 * 
 */
package the.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houjianguang
 *
 */
@RestController
@SpringBootApplication
public class ConfigClientApp {

	@Value("${db.url}") String url;
	@Value("${db.username}") String userName;
	@Value("${db.password}") String password;
	
	@RequestMapping("/dbconfiginfo")
	public String getValue() {
		return "URL :" + url + " UserName:" + userName + " Password:" + password;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApp.class, args);
	}

}
