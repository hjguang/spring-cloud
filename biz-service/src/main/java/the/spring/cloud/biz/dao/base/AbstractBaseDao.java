package the.spring.cloud.biz.dao.base;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * dao基类，统一提供基本的CRUD
 * @param <T>
 */
public class AbstractBaseDao<T> extends SqlSessionDaoSupport {

    protected static final String POSTFIX_SELECTONE = "selectByPrimaryKey";
    protected static final String POSTFIX_INSERT = "insertSelective";
    protected static final String POSTFIX_UPDATE = "updateByPrimaryKeySelective";

    String getStatement(String classPath, String sqlId) {
        StringBuilder sb = new StringBuilder();
        sb.append(classPath).append(".").append(sqlId);
        return sb.toString();
    }

    public <T> T selectById(Class<T> clazz, Integer id) {
        String statement = this.getStatement(clazz.getName(), POSTFIX_SELECTONE);
        return this.getSqlSession().selectOne(statement, id);
    }

    public <T> int insert(T entity) {
        String statement = this.getStatement(entity.getClass().getName(), POSTFIX_INSERT);
        return this.getSqlSession().insert(statement,entity);
    }

    public <T> int update(T entity) {
        String statement = this.getStatement(entity.getClass().getName(), POSTFIX_UPDATE);
        return this.getSqlSession().update(statement, entity);
    }

    public <T> List<T> selectList(String statement, Object param) {
        return this.getSqlSession().selectList(statement, param);
    }
}
