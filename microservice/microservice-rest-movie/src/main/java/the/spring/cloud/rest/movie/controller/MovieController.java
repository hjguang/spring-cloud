package the.spring.cloud.rest.movie.controller;

import org.springframework.web.bind.annotation.*;
import the.spring.cloud.api.model.MovieDto;
import the.spring.cloud.rest.movie.model.Movie;
import the.spring.cloud.rest.movie.service.MovieMongoService;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/get/{movieId}")
    public Movie selectById(@PathVariable String movieId) {
        return movieMongoService.selectById(movieId);
    }
    @GetMapping("/list/{name}")
    public List<Movie> list(@PathVariable String name) {
        List<Movie> list = movieMongoService.query(name);
        return list;
    }
}
