package the.spring.cloud.rest.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRestApplication.class, args);
    }

}
