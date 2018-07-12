package the.spring.cloud.biz.util;

import com.google.gson.Gson;

public class JsonUtils {

    public static String toJsonString(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
