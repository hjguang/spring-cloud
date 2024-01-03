package the.spring.cloud.rest.api.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiRestConfig {

    @LoadBalanced
    @Bean
    public RestTemplate urlCleanedRestTemplate() {
        return new RestTemplate();
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
