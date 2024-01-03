package the.spring.cloud.rest.movie.test;

import the.spring.cloud.rest.movie.entity.Movie;
import the.spring.cloud.utils.common.JsonUtils;

public class JsonUtilTest {

    public static void main(String[] args) {
        String str = "{\"movieId\":\"64464024ab52a06560acfd4e\",\"name\":\"少林寺\",\"starring\":\"李连杰\",\"commentList\":[{\"content\":\"非常好看\",\"userId\":\"user:0\",\"commentDate\":\"2023-04-24 16:39:00\"}]}";

        Movie object = JsonUtils.toObject(str, Movie.class);
        System.out.println(object.getName());
    }
}
