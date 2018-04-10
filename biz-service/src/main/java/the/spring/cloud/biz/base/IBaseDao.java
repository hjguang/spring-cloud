package the.spring.cloud.biz.base;

import com.github.pagehelper.Page;

public interface IBaseDao<T> {

    T selectById(Integer id);

    Page<T> selectListByPage(String statementPostfix, Object entity);
}
