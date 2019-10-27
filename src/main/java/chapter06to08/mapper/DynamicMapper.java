package chapter06to08.mapper;

import chapter06to08.model.Customer;

import java.util.List;

public interface DynamicMapper {

    /** if */
    public List<Customer> findByNameAndJobs(Customer customer);

    /** choose-when-otherwise */
    public List<Customer> findByNameOrJobs(Customer customer);

    /** where-if */
    public List<Customer> findByNameAndJobs2(Customer customer);

    /** trim-if */
    public List<Customer> findByNameAndJobs3(Customer customer);

    /** foreach */
    public List<Customer> findByIds(List<Integer> ids);

    /** bind */
    public List<Customer> findByName(String name);

    /** set */
    public int update(Customer customer);

}
