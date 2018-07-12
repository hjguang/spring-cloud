package the.spring.cloud.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import the.spring.cloud.biz.dao.TransTestDao;
import the.spring.cloud.biz.entity.test.TransTest;
import the.spring.cloud.biz.service.TransService;
import the.spring.cloud.biz.util.MybatisUtil;

import java.util.List;

@Service
public class TransServiceImpl implements TransService {
    @Override
    public TransTest getById(Integer id) {
        return transTestDao.selectById(id);
    }

    @Override
    public int save(TransTest entity) {
        return transTestDao.save(entity);
    }

    @Override
    public List<TransTest> list() {
        return transTestDao.selectList(MybatisUtil.getMybatisStatement(TransTest.class,"selectList"),null);
    }

    @Autowired
    TransTestDao transTestDao;
}
