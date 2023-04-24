package the.spring.cloud.api.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieDto {

    private String movieId;
    private String name;
    private String starring;
    private Date publishDate;

    private List<CommentDto> commentList;
}
