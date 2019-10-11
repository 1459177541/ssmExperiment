package chapter2.main;

import chapter2.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class prototype {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter2/applicationContext-prototype.xml");
        Service service1 = applicationContext.getBean(Service.class);
        Service service2 = applicationContext.getBean(Service.class);
        System.out.println(service1 == service2);
    }
}
