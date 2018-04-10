package the.spring.cloud.biz.base;

import java.lang.reflect.ParameterizedType;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

public abstract class AbstractBaseDao<T> extends SqlSessionDaoSupport {

    protected static final String POSTFIX_SELECTONE = ".selectByPrimaryKey";

    Class<T> clazz;

    @Autowired
    DataSource dataSource;

    @Value("${mybatis.config-location}")
    private String location;
    @Value("${mybatis.mapper-locations}")
    private String locationPattern;

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setConfigLocation(resolver.getResource(location));
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));

        return sqlSessionFactoryBean.getObject();
    }

    String getStatement(String sqlId) {
        clazz = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String name = clazz.getName();
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(sqlId);
        return sb.toString();
    }

   
}
