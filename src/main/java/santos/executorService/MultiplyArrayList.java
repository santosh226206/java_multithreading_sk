package santos.executorService;

import java.util.*;
import java.util.concurrent.*;

public class MultiplyArrayList {
    private static final int SIZE = 2000;
    private static final int THREADS = 4;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            numbers.add(i);
        }

        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        List<Future<List<Integer>>> futures = new ArrayList<>();
        int chunkSize = SIZE / THREADS;

        for (int i = 0; i < THREADS; i++) {
            int start = i * chunkSize;
            int end = (i == THREADS - 1) ? SIZE : start + chunkSize;
            futures.add(executor.submit(new MultiplyTask(numbers.subList(start, end))));
        }

        List<Integer> result = new ArrayList<>(SIZE);
        try {
            for (Future<List<Integer>> future : futures) {
                result.addAll(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.println("First 10 elements of result: " + result.subList(0, 10));
    }
}

class MultiplyTask implements Callable<List<Integer>> {
    private final List<Integer> subList;

    public MultiplyTask(List<Integer> subList) {
        this.subList = subList;
    }

    @Override
    public List<Integer> call() {
        List<Integer> multiplied = new ArrayList<>(subList.size());
        for (int num : subList) {
            multiplied.add(num * 2);
        }
        return multiplied;
    }
}

