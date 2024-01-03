package the.spring.cloud.utils.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.TimeZone;

/**
 * json工具类
 */
@Slf4j
public class JsonUtils {

    public static String toJsonString(Object obj) {
        if (obj == null) {
            return null;
        }
        String result = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            //设置时区
            mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            //忽略null字段
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("对象转json异常:{}", e.getMessage());
        }
        return result;
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        if (!StringUtils.hasText(json)) {
            return null;
        }
        T t = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            //设置时区
            mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            //忽略null字段
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            t = clazz.equals(String.class) ? (T) json : mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("json转对象异常:{}", e.getMessage());
        }
        return t;
    }
}
