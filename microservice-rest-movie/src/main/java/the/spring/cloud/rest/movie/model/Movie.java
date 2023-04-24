package the.spring.cloud.rest.movie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Movie implements Serializable {

    private static final long serialVersionUID = 5753419118484431979L;

    @Field(name = "_id")
    private String movieId;
    private String name;
    private String starring;

    @Field(name = "publish_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;


    private List<Comment> commentList;
}
