package chapter3.main;

import chapter3.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJ {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter3/applicationContext-aspectJ.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.addUser();
        System.out.println("=======================================");
        userDao.deleteruser();
    }

}
