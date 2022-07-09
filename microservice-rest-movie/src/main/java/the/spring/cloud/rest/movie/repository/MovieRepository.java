package the.spring.cloud.rest.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import the.spring.cloud.rest.movie.model.Movie;

public interface MovieRepository extends MongoRepository<Movie,String> {
}
