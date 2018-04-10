package the.spring.cloud.biz.base;

import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Component
public class BaseDao<T> extends AbstractBaseDao<T> implements IBaseDao<T> {
	
	
	 @Override
	    public T selectById(Integer id) {
	        return this.getSqlSession().selectOne(getStatement(POSTFIX_SELECTONE),id);
	    }

	    @Override
	    public Page<T> selectListByPage(String statementPostfix, Object entity) {

	        Page<T> page = PageHelper.startPage(1,10);
	       getSqlSession().selectList(this.getStatement(statementPostfix));
	       return page;
	    }
}
