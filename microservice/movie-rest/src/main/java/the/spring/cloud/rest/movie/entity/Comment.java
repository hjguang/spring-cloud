package the.spring.cloud.rest.movie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Comment {

    private String content;
    private String userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentDate;
}
