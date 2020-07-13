package se;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest {
    @Test
    public void normalFutureTest() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {
           throw new Exception ();
        });
        try{
            future.get();
        } catch (ExecutionException e) {
            System.out.println("Execution Wrong");
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }
    }
    @Test
    public void listenableFutureTest() {
        CompletableFuture<Integer> future = CompletableFuture
                .completedFuture(Lists.newArrayList(1, 2, 3))
                .thenApply((list) -> list.get(1));
        try{
            Integer i = future.get();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
