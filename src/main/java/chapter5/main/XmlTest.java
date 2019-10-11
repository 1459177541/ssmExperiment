package chapter5.main;

import chapter5.dao.AccountDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlTest {

    private static AccountDao accountDao;

    @BeforeAll
    static void start(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter5/applicationContext.xml");
        accountDao = applicationContext.getBean(AccountDao.class);
    }

    @Test
    void noErrorTransfer(){
        accountDao.transfer(1, 2, 10.5, false);
    }

    @Test
    void hasErrorTransfer(){
        Assertions.assertThrows(ArithmeticException.class,
                ()->accountDao.transfer(1, 2, 10.5, true));
    }

}
