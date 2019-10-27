package chapter03.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ProxyAspect implements MethodInterceptor {

    public void checkPermissions(){
        System.out.println("模拟检查权限");
    }

    public void log(){
        System.out.println("模拟记录日记");
    }

    public void error(Exception e){
        System.out.println("出现问题："+e.getMessage());
        e.printStackTrace();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        checkPermissions();
        try{
            return methodInvocation.proceed();
        } catch (Exception e){
            error(e);
            throw e;
        } finally {
            log();
        }
    }
}
