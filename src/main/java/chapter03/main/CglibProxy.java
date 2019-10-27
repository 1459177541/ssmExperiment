package chapter03.main;

import chapter03.dao.impl.NoInterfaceUserDao;
import chapter03.cglib.Handler;
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
