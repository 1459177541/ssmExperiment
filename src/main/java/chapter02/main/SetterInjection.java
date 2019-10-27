package chapter02.main;

import chapter02.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjection {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter02/applicationContext-setter.xml");
        Service service = applicationContext.getBean(Service.class);
        System.out.println(service.say());
    }

}
