package chapter02.main;

import chapter02.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Singleton {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter02/applicationContext-singleton.xml");
        Service service1 = applicationContext.getBean(Service.class);
        Service service2 = applicationContext.getBean(Service.class);
        System.out.println(service1 == service2);
    }
}
