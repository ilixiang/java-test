package se;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class JdkProxyTest {
    @Test
    public void proxyTest() throws NoSuchMethodException {
        Hello helloProxy = (Hello) Proxy.newProxyInstance(
                Hello.class.getClassLoader(),
                new Class<?>[] {Hello.class},
                new HelloInvocationHandler(new HelloWorld())
        );
        helloProxy.sayHello();
        System.out.println(helloProxy.getClass().getName());
    }
}
