package the.spring.cloud.rest.movie.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import the.spring.cloud.rest.movie.entity.Movie;
import the.spring.cloud.rest.movie.repository.MovieRepository;
import the.spring.cloud.rest.movie.service.MovieMongoService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class MovieMongoServiceImpl implements MovieMongoService {

    @Resource
    MovieRepository movieRepository;
    @Resource
    MongoTemplate mongoTemplate;


    @Override
    public Movie createMovie(Movie movie) {
        movieRepository.insert(movie);
        return movie;
    }

    @Override
    public Movie selectById(String movieId) {
        return mongoTemplate.findById(movieId,Movie.class);
    }

    @Override
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> query(String name) {
        return movieRepository.findMovieByName(name);
    }

    @Override
    public Page<Movie> findList(Movie movie, int pageIndex, int pageSize, String orderBy) {
        Sort sort = Sort.by(Sort.Direction.ASC, orderBy);
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);

        List<Criteria> criteriaList = new ArrayList<>();
        if (StringUtils.isNoneBlank(movie.getName())) {
            Pattern pattern = Pattern.compile(".*?" + movie.getName() + ".*");
            criteriaList.add(Criteria.where("name").regex(pattern));
        }
        if (StringUtils.isNoneBlank(movie.getStarring())) {
            criteriaList.add(Criteria.where("protagonist").is(movie.getStarring()));
        }


        Criteria[] criterias = criteriaList.toArray(Criteria[]::new);
        Query query = null;

        query = new Query(new Criteria().andOperator(criterias)).with(sort).with(pageable);
        long total = mongoTemplate.count(query, Movie.class);
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        return new PageImpl<>(movies, pageable, total);
    }

    @Override
    public Page<Movie> findListUseExample(Movie movie, int pageIndex, int pageSize, String orderBy) {

        Sort sort = Sort.by(Sort.Direction.ASC, orderBy);
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnorePaths("_id")
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("protagonist", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<Movie> example = Example.of(movie, matcher);
        Page<Movie> moviePage = movieRepository.findAll(example, pageable);

        return moviePage;
    }

}
