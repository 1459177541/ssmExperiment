package chapter10.dao.impl;

import chapter10.dao.CustomerDao;
import chapter10.model.Customer;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {

    @Override
    public Customer findById(int id) {
        return getSqlSession().selectOne("chapter10.mapper.CustomerMapper.findById", id);
    }

}
