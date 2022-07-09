package the.spring.cloud.rest.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import javax.annotation.Resource;

/**
 * mongodb配置类
 * @date 2022年7月9日
 */
@Configuration
public class MongoConfig {

    @Resource
    private MongoDatabaseFactory factory;
    @Resource
    private MongoMappingContext context;

    @Bean
    public MappingMongoConverter mappingMongoConverter() {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, context);

        // 删除mongo数据库中的class默认字段
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        return converter;
    }
}
