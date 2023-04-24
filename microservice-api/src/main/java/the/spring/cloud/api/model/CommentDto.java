package the.spring.cloud.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {

    private String content;
    private String userId;
    private Date commentDate;
}
