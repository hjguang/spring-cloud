package the.spring.cloud.biz.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
public class DruidDBConfig {

	@Value("${mybatis.config-location}")
	private String location;
	@Value("${mybatis.mapper-locations}")
	private String locationPattern;
	
	@Bean
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource(location));
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));

		return sqlSessionFactoryBean.getObject();
	}
}
