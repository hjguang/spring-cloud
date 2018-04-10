package the.spring.cloud.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import the.spring.cloud.biz.dao.GoodsAdminDao;
import the.spring.cloud.biz.entity.Goods;
import the.spring.cloud.biz.service.GoodsAdminService;

@Service
public class GoodsAdminServiceImpl implements GoodsAdminService {

    @Autowired
    GoodsAdminDao goodsAdminDao;

    @Override
    public Goods selectById(Integer id) {
        return goodsAdminDao.selectById(id);
    }

    @Override
    public Page<Goods> selectList(Goods param) {

        return goodsAdminDao.selectListByPage(".selectList", param);
    }
}
