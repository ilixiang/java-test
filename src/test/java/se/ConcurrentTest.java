package se;

import org.junit.Test;

import java.util.stream.LongStream;

public class ConcurrentTest {
    @Test
    public void forkJoinTest() {
        long[] numbers = LongStream.rangeClosed(1, 100).toArray();
        SumTask sumTask = new SumTask(numbers, 0, numbers.length);
        sumTask.fork();
        System.out.println(sumTask.join());
    }

    @Test
    public void diningPhilosophyProblem() {

    }

}
