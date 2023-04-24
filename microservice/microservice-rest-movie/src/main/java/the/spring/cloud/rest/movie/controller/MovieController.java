package the.spring.cloud.rest.movie.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import the.spring.cloud.api.model.MovieDto;
import the.spring.cloud.rest.movie.model.Movie;
import the.spring.cloud.rest.movie.service.MovieMongoService;

import javax.annotation.Resource;

@RestController
@RequestMapping("movie/")
public class MovieController {

    @Resource
    MovieMongoService movieMongoService;

    @PostMapping("/add")
    public Movie add(@RequestBody Movie movie) {
        movie = movieMongoService.createMovie(movie);
        return movie;
    }
}
