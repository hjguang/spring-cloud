package the.spring.cloud.rest.movie.service;

import org.springframework.data.domain.Page;
import the.spring.cloud.rest.movie.model.Movie;

import java.util.List;

public interface MovieMongoService {

    Movie createMovie(Movie movie);

    List<Movie> list();

    List<Movie> query(String name);

    /**
     * 使用Criteria的动态查询
     * @param movie
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @return
     */
    Page<Movie> findList(Movie movie, int pageIndex, int pageSize, String orderBy);

    /**
     * 使用Example的动态查询
     * @param movie
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @return
     */
    Page<Movie> findListUseExample(Movie movie, int pageIndex, int pageSize, String orderBy);
}
