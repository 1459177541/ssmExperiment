package chapter3.jdk;

import chapter3.aspect.Aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final Object target;

    private final Aspect aspect;

    public Handler(Object target){
        this.target = target;
        aspect = new Aspect();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aspect.checkPermissions();
        try{
            return method.invoke(target, args);
        } catch (Exception e){
            aspect.error(e);
            throw e;
        } finally {
            aspect.log();
        }
    }
}
