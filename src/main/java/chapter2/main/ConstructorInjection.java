package chapter2.main;

import chapter2.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjection {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter2/applicationContext-constructor.xml");
        Service service = applicationContext.getBean(Service.class);
        System.out.println(service.say());
    }
}
