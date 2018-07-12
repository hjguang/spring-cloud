package the.spring.cloud.biz.dao;

import the.spring.cloud.biz.entity.test.TransTest;

import java.util.List;

public interface TransTestDao {

    TransTest selectById(Integer id);

    int save(TransTest entity);

    List<TransTest> selectList(String statement, Object param);
}
