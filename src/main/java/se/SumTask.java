package se;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    private long[] numbers;
    private int from;
    private int to;

    public SumTask(long[] numbers, int from, int to) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if(to - from < 10) {
            for(int i = from; i < to; ++i) {
                sum += numbers[i];
            }
            return sum;
        }
        int middle = (from + to) / 2;
        SumTask leftTask = new SumTask(numbers, from, middle);
        SumTask rightTask = new SumTask(numbers, middle, to);
        leftTask.fork();
        rightTask.fork();
        return leftTask.join() + rightTask.join();
    }
}
