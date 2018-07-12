package the.spring.cloud.biz.dao.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SecondBaseDao<T> extends AbstractBaseDao<T> {

    @Resource
    public void setSecondSqlSessionFactory(SqlSessionFactory secondSqlSessionFactory) {
        super.setSqlSessionFactory(secondSqlSessionFactory);
    }
}
