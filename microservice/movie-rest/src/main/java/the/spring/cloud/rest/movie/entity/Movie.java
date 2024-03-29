package the.spring.cloud.rest.movie.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import the.spring.cloud.utils.common.ObjectIdJsonSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Document
public class Movie implements Serializable {

    private static final long serialVersionUID = 5753419118484431979L;

    @Id
    @Field(name = "_id")
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    private ObjectId movieId; //主键定义为ObjectId
    private String name;
    private String starring;

    @Field(name = "publish_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;


    private List<Comment> commentList;
}
