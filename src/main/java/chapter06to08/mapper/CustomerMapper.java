package chapter06to08.mapper;

import chapter06to08.model.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    public Customer findOne(int id);

    public List<Customer> findAll();

    public List<Customer> findByColumn(@Param("column") String column,@Param("value") String value);

    public List<Customer> findByName(String name);

    public int save(Customer customer);

    public int delete(int id);

    public int update(Customer customer);
}
