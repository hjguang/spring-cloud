package the.spring.cloud.biz.dao.impl;

import org.springframework.stereotype.Component;

import the.spring.cloud.biz.base.BaseDao;
import the.spring.cloud.biz.dao.GoodsAdminDao;
import the.spring.cloud.biz.entity.Goods;

@Component
public class GoodsAdminDaoImpl extends BaseDao<Goods> implements GoodsAdminDao {

}
