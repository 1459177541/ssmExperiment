package chapter10.mapper;

import chapter10.model.Customer;

public interface CustomerMapper {
    public Customer findById(int id);
    public void addCustomer(Customer customer);
}
