package chapter3.main;

import chapter3.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyFactory {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter3/applicationContext-proxy.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
        System.out.println("=======================================");
        userDao.deleteruser();
    }

}
