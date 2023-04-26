package the.spring.cloud.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import the.spring.cloud.api.model.MovieDto;
import the.spring.cloud.api.service.MovieServiceRestApi;
import the.spring.cloud.rest.api.feign.MovieFeignClient;
import the.spring.cloud.utils.common.JsonUtils;

@RestController
@RequestMapping("/rest-movie")
public class MovieServiceRest implements MovieServiceRestApi {

    @Autowired
    private RestTemplate urlCleanedRestTemplate;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    MovieFeignClient movieFeignClient;

    private static final String MOVIE_SERVICE_PROVIDER_ADDRESS = "http://microservice-rest-movie";

    @Override
    public String getMovieById(String movieId) {

//        String result = urlCleanedRestTemplate.getForObject(MOVIE_SERVICE_PROVIDER_ADDRESS + "/movie/get/" + movieId, String.class);
        String s = movieFeignClient.selectById(movieId);
        System.out.println(s);
        return s;
    }

    @GetMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }
}
