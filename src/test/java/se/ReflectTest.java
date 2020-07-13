package se;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ReflectTest {

    @Test
    public void testGetClazz() throws ClassNotFoundException {
        Class<?> clazz1 = HelloWorld.class;

        HelloWorld helloWorld = new HelloWorld();
        Class<?> clazz2 = helloWorld.getClass();

        Class<?> clazz3 = Class.forName("se.HelloWorld");
    }

    @Test
    public void testGetMethods() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = HelloWorld.class;
        HelloWorld helloWorld = new HelloWorld();
        Method method = clazz.getMethod("sayHello");
        method.invoke(helloWorld);
    }

    @Test
    public void methodPerformanceTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final long CIRCLES = 1000000;
        HelloWorld helloWorld = new HelloWorld();
        Stopwatch stopwatch = Stopwatch.createUnstarted();

        stopwatch.start();
        for(int i = 0; i < CIRCLES; ++i) {
            Class.forName("se.HelloWorld").getMethod("sayHello").invoke(helloWorld);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        // Find Class then get method
        stopwatch.reset();
        stopwatch.start();
        for(int i = 0; i < CIRCLES; ++i) {
            HelloWorld.class.getMethod("sayHello").invoke(helloWorld);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        // Cache Class
        Class<?> helloWorldClazz = Class.forName("se.HelloWorld");
        stopwatch.reset();
        stopwatch.start();
        for(int i = 0; i < CIRCLES; ++i) {
            helloWorldClazz.getMethod("sayHello").invoke(helloWorld);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        // Cache method
        Method helloMethod = Class.forName("se.HelloWorld").getMethod("sayHello");
        stopwatch.reset();
        stopwatch.start();
        for(int i = 0; i < CIRCLES; ++i) {
            helloMethod.invoke(helloWorld);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));

        // Invoke method directly
        stopwatch.reset();
        stopwatch.start();
        for(int i = 0; i < CIRCLES; ++i) {
            helloWorld.sayHello();
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void getClassesTest() {
        Set<Class<?>> visited = new HashSet<>();
        Queue<Class<?>> queue = new LinkedList<>();
        queue.add(String.class);
        while(!queue.isEmpty()) {
            Class<?> clazz = queue.poll();
            if(visited.contains(clazz)) continue;
            visited.add(clazz);
            if(Objects.nonNull(clazz.getSuperclass()))
                queue.add(clazz.getSuperclass());
            queue.addAll(Arrays.asList(clazz.getInterfaces()));
        }
        visited.forEach(System.out::println);
    }

}
