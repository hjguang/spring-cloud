package the.spring.cloud.biz.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

public abstract class AbstractDBConfig {

    public SqlSessionFactory initSqlSessionFactory(DataSource dataSource, String location, String locationPattern ) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(location));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));

        return sqlSessionFactoryBean.getObject();
    }
}
