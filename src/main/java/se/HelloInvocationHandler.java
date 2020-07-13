package se;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocationHandler implements InvocationHandler {

    private Hello hello;

    public HelloInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("Before " + method.getName());
        Object result = method.invoke(hello, objects);
        System.out.println("After " + method.getName());
        return result;
    }
}
