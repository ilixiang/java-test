package se;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before " + method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("After " + method.getName());
        return result;
    }
}
