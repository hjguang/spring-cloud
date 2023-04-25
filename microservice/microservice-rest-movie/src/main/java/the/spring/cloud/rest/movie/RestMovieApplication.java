package the.spring.cloud.rest.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestMovieApplication.class, args);
    }

}
