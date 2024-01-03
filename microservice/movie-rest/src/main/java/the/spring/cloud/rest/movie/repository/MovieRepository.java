package the.spring.cloud.rest.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import the.spring.cloud.rest.movie.entity.Movie;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie,String> {


    List<Movie> findMovieByName(String name);
}
