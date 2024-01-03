package the.spring.cloud.rest.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import the.spring.cloud.api.model.MovieDto;

/**
 * feign client调用
 */
@FeignClient(name = "microservice-rest-movie", contextId = "microservice-rest-movie")
public interface MovieFeignClient {

    @GetMapping("/movie/get/{movieId}")
    MovieDto selectById(@PathVariable String movieId);
}
