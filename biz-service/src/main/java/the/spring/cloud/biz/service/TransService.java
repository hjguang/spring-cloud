package the.spring.cloud.biz.service;

import the.spring.cloud.biz.entity.test.TransTest;

import java.util.List;

public interface TransService {

    TransTest getById(Integer id);

    int save(TransTest entity);

    List<TransTest> list();
}
