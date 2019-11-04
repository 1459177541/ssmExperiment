package chapter10.service.impl;

import chapter10.mapper.CustomerMapper;
import chapter10.model.Customer;
import chapter10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper){
        this.customerMapper = customerMapper;
    }

    @SuppressWarnings({"divzero", "NumericOverflow"})
    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
        System.out.println(1/0);
    }
}
