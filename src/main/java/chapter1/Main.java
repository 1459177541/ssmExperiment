package chapter1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter1/applicationContext.xml");
        A a = applicationContext.getBean(A.class);
        a.say();
    }
}
