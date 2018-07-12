package the.spring.cloud.biz.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class FirstDBConfig extends AbstractDBConfig {

    @Value("${mybatis.config-location}")
    private String location;
    @Value("${mybatis.mapper-locations}")
    private String locationPattern;


    @Bean
    @Primary
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "firstSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        return super.initSqlSessionFactory(dataSource, location, locationPattern);
    }
}
