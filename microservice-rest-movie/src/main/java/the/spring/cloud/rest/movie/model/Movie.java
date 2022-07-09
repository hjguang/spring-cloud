package the.spring.cloud.rest.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document
public class Movie implements Serializable {

    private String name;
}
