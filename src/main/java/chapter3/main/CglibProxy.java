package chapter3.main;

import chapter3.dao.impl.NoInterfaceUserDao;
import chapter3.cglib.Handler;
import org.springframework.cglib.proxy.Enhancer;

public class CglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(NoInterfaceUserDao.class);
        enhancer.setCallback(new Handler());
        NoInterfaceUserDao proxy = (NoInterfaceUserDao) enhancer.create();
        proxy.addUser();
        System.out.println("=======================================");
        proxy.deleteruser();
    }
}
