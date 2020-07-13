package se;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorTest {
    @Test
    public void threadPoolExecutorTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(()->{
            return "hello world";
        });

        String result = null;

        try{
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(result);
    }
}
