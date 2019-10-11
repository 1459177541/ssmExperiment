package chapter3.main;

import chapter3.dao.UserDao;
import chapter3.dao.impl.UserDaoImpl;
import chapter3.jdk.Handler;

import java.lang.reflect.Proxy;

public class JdkProxy {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        Handler handler = new Handler(userDao);
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), new Class[]{UserDao.class}, handler);
        proxy.addUser();
        System.out.println("=======================================");
        proxy.deleteruser();
    }
}
