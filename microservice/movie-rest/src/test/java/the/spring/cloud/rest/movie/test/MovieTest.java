package the.spring.cloud.rest.movie.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import the.spring.cloud.rest.movie.entity.Comment;
import the.spring.cloud.rest.movie.entity.Movie;
import the.spring.cloud.rest.movie.service.MovieMongoService;
import the.spring.cloud.utils.common.JsonUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class MovieTest {

    @Resource
    MovieMongoService movieMongoService;

    @Test
    public void create() throws ParseException {
        String[] movieArr = List.of("少林寺","我是谁","少林足球","澳门风云","十面埋伏","疯狂的石头").toArray(String[]::new);
        String[] protagonists = List.of("李连杰","成龙","周星驰","周润发","章子怡","黄渤").toArray(String[]::new);
        for (int i = 0; i < movieArr.length; i++) {
            Movie movie = new Movie();
            movie.setName(movieArr[i]);
            movie.setStarring(protagonists[i]);
//            movie.setPublishDate(DateUtils.parseDate("1982-02-01", "yyyy-MM-dd"));
            List<Comment> comments = new ArrayList<>();
            Comment comment = new Comment();
            comment.setUserId("user:" + i);
            comment.setContent("非常好看");
            comment.setCommentDate(new Date());
            comments.add(comment);
            movie.setCommentList(comments);
            movieMongoService.createMovie(movie);
        }
    }

    @Test
    public void selectById() {

        Movie movie = movieMongoService.selectById("64464024ab52a06560acfd4e");
        System.out.println(JsonUtils.toJsonString(movie));
    }

    @Test
    public void list() {
        movieMongoService.list().forEach(item -> System.out.println(item.getName()));
    }

    @Test
    public void query() {
        List<Movie> list; //= movieMongoService.list();
        list = movieMongoService.query("唐伯虎点秋香1");
        System.out.println(JsonUtils.toJsonString(list));

    }

    @Test
    public void pageQuery() {
        Movie m = new Movie();
//        m.setName("少林寺");
        m.setStarring("李连杰");
//        Page<Movie> result = movieMongoService.findListUseExample(m, 1, 10, "name");
        Page<Movie> result = movieMongoService.findList(m, 1, 10, "name");
        System.out.println(JsonUtils.toJsonString(result));
    }
}
