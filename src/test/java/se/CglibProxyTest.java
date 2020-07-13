package se;

import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class CglibProxyTest {
    @Test
    public void proxyTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloWorld.class);
        enhancer.setCallback(new HelloMethodInterceptor());
        HelloWorld helloWorld = (HelloWorld)enhancer.create();
        helloWorld.sayHello();
        System.out.println(helloWorld.getClass().getName());
    }
}
