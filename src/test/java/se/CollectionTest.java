package se;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CollectionTest {
    @Test
    public void listTest() {
        List<Integer> copyOnWriteArrayList = Lists.newCopyOnWriteArrayList();
    }

    @Test
    public void streamTest() {
        List<Integer> list = Lists.newArrayList(4, 3, 5, 9);
        list.stream().map(x -> Math.pow(x, 2)).filter(x -> x % 2 == 1).collect(Collectors.toList());
    }

    @Test
    public void concurrentModifyExceptionTest() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 5);
        Iterator<Integer> i = list.iterator();
        ExecutorService fixThreadPool = Executors.newFixedThreadPool(1);
        fixThreadPool.submit(() -> {
            while(true){
                list.add(RandomUtils.nextInt());
            }
        });
        while(true) {
            for(Integer x: list) {
                System.out.println(x);
            }
        }
    }
}
