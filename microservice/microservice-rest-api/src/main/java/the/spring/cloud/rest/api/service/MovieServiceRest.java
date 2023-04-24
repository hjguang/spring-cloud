package the.spring.cloud.rest.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import the.spring.cloud.api.model.MovieDto;
import the.spring.cloud.api.service.MovieServiceRestApi;

@RestController
@RequestMapping("/movie")
public class MovieServiceRest implements MovieServiceRestApi {

    @Override
    public MovieDto getMovieById(String movieId) {
        return new MovieDto();
    }
}
