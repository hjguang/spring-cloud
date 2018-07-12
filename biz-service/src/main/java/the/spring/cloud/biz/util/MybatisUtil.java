package the.spring.cloud.biz.util;

public class MybatisUtil {

    public static String getMybatisStatement(Class<?> clazz, String method) {
        StringBuffer buffer = new StringBuffer(clazz.getName());
        buffer.append(".").append(method);
        return buffer.toString();
    }
}
