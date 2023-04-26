package the.spring.cloud.rest.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceUserApplication {
    public static void main(String[] args) {

        SpringApplication.run(MicroserviceUserApplication.class, args);
    }
}
