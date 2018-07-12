package the.spring.cloud.biz.dao;


import the.spring.cloud.biz.entity.Goods;

public interface GoodsAdminDao {

    Goods selectById(Integer id);
}
