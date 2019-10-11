package chapter3.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

    @Pointcut("execution(* chapter3.dao.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void checkPermissions(){
        System.out.println("模拟检查权限");
    }

    @After("pointcut()")
    public void log(){
        System.out.println("模拟记录日记");
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void error(Exception e){
        System.out.println("出现问题："+e.getMessage());
        e.printStackTrace();
    }
}
