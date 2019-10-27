package chapter02.main;

import chapter02.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationInjection2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("chapter02");
        Service service = applicationContext.getBean(Service.class);
        System.out.println(service.say());
    }
}
