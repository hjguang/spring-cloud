package the.spring.cloud.utils.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.TimeZone;

public class JsonUtils {

    public static String toJsonString(Object obj){
        String result = "";
        ObjectMapper mapper = new ObjectMapper();
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {

        }
        return result;
    }
}
