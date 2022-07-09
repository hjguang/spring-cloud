package the.spring.cloud.rest.movie.service.impl;

import org.springframework.stereotype.Service;
import the.spring.cloud.rest.movie.model.Movie;
import the.spring.cloud.rest.movie.repository.MovieRepository;
import the.spring.cloud.rest.movie.service.MovieMongoService;

import javax.annotation.Resource;

@Service
public class MovieMongoServiceImpl implements MovieMongoService {

    @Resource
    MovieRepository movieRepository;


    @Override
    public void createMovie() {
        movieRepository.save(new Movie("唐伯虎点秋香"));
    }
}
