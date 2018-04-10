package the.spring.cloud.biz.service;

import com.github.pagehelper.Page;

import the.spring.cloud.biz.entity.Goods;

public interface GoodsAdminService {

    Goods selectById(Integer id);

    Page<Goods> selectList(Goods param);
}
