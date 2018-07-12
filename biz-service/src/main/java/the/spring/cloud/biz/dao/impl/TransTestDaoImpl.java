package the.spring.cloud.biz.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import the.spring.cloud.biz.dao.TransTestDao;
import the.spring.cloud.biz.dao.base.SecondBaseDao;
import the.spring.cloud.biz.entity.test.TransTest;

import java.util.List;

@Component
public class TransTestDaoImpl implements TransTestDao {

    @Autowired
    SecondBaseDao<TransTest> secondBaseDao;

    @Override
    public TransTest selectById(Integer id) {
        return secondBaseDao.selectById(TransTest.class, id);
    }

    @Override
    public int save(TransTest entity) {
        if (entity.getId() == null) {
            secondBaseDao.insert(entity);
        } else {
            secondBaseDao.update(entity);
        }
        return 0;
    }

    @Override
    public List<TransTest> selectList(String statement, Object param) {
        return secondBaseDao.selectList(statement,param);
    }
}
