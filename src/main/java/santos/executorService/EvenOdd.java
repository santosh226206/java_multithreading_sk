//package santos.executorService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.*;
//import java.util.stream.Collectors;
//
//public class EvenOdd {
//    public static void main(String[] args) throws Exception {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10_000_000; i++) {
//            list.add(i);
//        }
//
//        // --- Synchronous Processing ---
//        long startTime = System.currentTimeMillis();
//
//        List<String> stringList = list.stream()
//                .map(item -> {
//                    if (item % 2 == 0) {
//                        return "even";
//                    } else {
//                        return "odd";
//                    }
//                })
//                .collect(Collectors.toList());
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time taken to populate stringList (sync): " + (endTime - startTime) + " ms");
//
//        // --- Asynchronous Processing using ExecutorService and CompletableFuture ---
//        ExecutorService executorService = Executors.newFixedThreadPool(15);
//        long startTimeAsync = System.currentTimeMillis();
//
//        // Process each item asynchronously and collect futures
//        List<CompletableFuture<String>> futureList = list.stream()
//                .map(item -> CompletableFuture.supplyAsync(() -> {
//                    if (item % 2 == 0) {
//                        return "even";
//                    } else {
//                        return "odd";
//                    }
//                }, executorService))
//                .collect(Collectors.toList());
//
//        // Join all futures and collect results
//        List<String> asyncStringList = futureList.stream()
//                .map(future -> {
//                    return future.join();
//                })
//                .collect(Collectors.toList());
//
//        long endTimeAsync = System.currentTimeMillis();
//        System.out.println("Time taken to populate stringList (async): " + (endTimeAsync - startTimeAsync) + " ms");
//
//        executorService.shutdown();
//    }
//}
package santos.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class EvenOdd {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        // --- Synchronous Processing ---
        long startTime = System.currentTimeMillis();

        List<String> stringList = list.stream()
                .map(item -> {
                    if (item % 2 == 0) {
                        return "even";
                    } else {
                        return "odd";
                    }
                })
                .collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to populate stringList (sync): " + (endTime - startTime) + " ms");

        // --- Asynchronous Processing using ExecutorService and CompletableFuture ---
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        long startTimeAsync = System.currentTimeMillis();

        // Using block lambda for the entire map
        List<CompletableFuture<String>> futureList = list.stream()
                .map(item -> {
                    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                        if (item % 2 == 0) {
                            return "even";
                        } else {
                            return "odd";
                        }
                    }, executorService);
                    return future;
                })
                .collect(Collectors.toList());

        // Join all futures using block lambda
        List<String> asyncStringList = futureList.stream()
                .map(future -> {
                    return future.join();
                })
                .collect(Collectors.toList());

        long endTimeAsync = System.currentTimeMillis();
        System.out.println("Time taken to populate stringList (async): " + (endTimeAsync - startTimeAsync) + " ms");

        executorService.shutdown();
    }
}
