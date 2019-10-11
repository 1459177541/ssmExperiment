package chapter3.cglib;

import chapter3.aspect.Aspect;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Handler implements MethodInterceptor {

    private Aspect aspect;

    public Handler(){
        aspect = new Aspect();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        aspect.checkPermissions();
        try{
            return methodProxy.invokeSuper(o, objects);
        } catch (Exception e){
            aspect.error(e);
            throw e;
        } finally {
            aspect.log();
        }
    }
}
