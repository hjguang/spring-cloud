package the.spring.cloud.biz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SecondDBConfig extends AbstractDBConfig {

    @Value("${second.datasource.url}")
    private String url;
    @Value("${second.datasource.username}")
    private String username;
    @Value("${second.datasource.password}")
    private String password;

    @Value("${mybatis.config-location}")
    private String location;
    @Value("${mybatis.second-mapper-locations}")
    private String locationPattern;

    @Bean(name = "secondDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("secondDataSource") DataSource secondDataSource) throws Exception {

        return super.initSqlSessionFactory(secondDataSource, location, locationPattern);
    }
}
