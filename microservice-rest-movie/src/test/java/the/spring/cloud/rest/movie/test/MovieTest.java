package the.spring.cloud.rest.movie.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import the.spring.cloud.rest.movie.service.MovieMongoService;

import javax.annotation.Resource;

@SpringBootTest
public class MovieTest {

    @Resource
    MovieMongoService movieMongoService;

    @Test
    public void create() {
        movieMongoService.createMovie();
    }
}
