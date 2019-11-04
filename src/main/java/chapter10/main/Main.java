package chapter10.main;

import chapter10.dao.CustomerDao;
import chapter10.mapper.CustomerMapper;
import chapter10.model.Customer;
import chapter10.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test
    public void traditional(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("chapter10/applicationContext-traditional.xml");
        CustomerDao customerDao = applicationContext.getBean(CustomerDao.class);
        System.out.println(customerDao.findById(1));
    }

    @Test
    public void mapperInterface(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("chapter10/applicationContext-mapperInterface.xml");
        CustomerMapper customerMapper = applicationContext.getBean(CustomerMapper.class);
        System.out.println(customerMapper.findById(1));
    }

    @Test
    public void mapperScanner(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("chapter10/applicationContext-mapperScanner.xml");
        CustomerMapper customerMapper = applicationContext.getBean(CustomerMapper.class);
        System.out.println(customerMapper.findById(1));
    }

    /**
     * 通过对 {@link chapter10.service.impl.CustomerServiceImpl} 上的
     * {@link org.springframework.transaction.annotation.Transactional} 注解添加与否开启或关闭事务进行测试.
     */
    @Test
    public void transactional(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("chapter10/applicationContext-transactional.xml");
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        Assertions.assertThrows(ArithmeticException.class,
                ()->customerService.addCustomer(
                        new Customer()
                                .setId(1)
                                .setName("user1")
                                .setJobs("student")
                                .setPhone("12345678910")
                ));

    }

}
