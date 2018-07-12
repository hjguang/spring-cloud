package the.spring.cloud.biz.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import the.spring.cloud.biz.dao.GoodsAdminDao;
import the.spring.cloud.biz.dao.base.FirstBaseDao;
import the.spring.cloud.biz.entity.Goods;

@Component
public class GoodsAdminDaoImpl implements GoodsAdminDao {

    @Autowired
    FirstBaseDao<Goods> firstBaseDao;

    @Override
    public Goods selectById(Integer id) {
        return firstBaseDao.selectById(Goods.class, id);
    }
}
