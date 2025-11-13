//package santos.concurrent;
//
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConcurrentTestOne {
//    public static void main(String[] args) throws InterruptedException {
//        List<Integer> numberArray=new ArrayList();
//        Thread thread1=new Thread(()->{
//            for(int i=0;i<1000;i++){
//                numberArray.add(i);
//            }
//        });
//        Thread thread2=new Thread(()->{
//            for (int i=0;i<1000;i++){
//                numberArray.add(i);
//            }
//        });
//        thread1.start();
//        thread2.start();
//        thread1.join();
//        thread2.join();
//        System.out.println(numberArray.size());
//    }
//}
//package santos.concurrent;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.*;
//
//public class ConcurrentTestOne {
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        // Use synchronized list to avoid ConcurrentModificationException
//        List<Integer> numberArray = Collections.synchronizedList(new ArrayList<>());
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2); // 2 threads
//
//        // Task 1
//        Callable<Void> task1 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                numberArray.add(i);
//            }
//            return null;
//        };
//
//        // Task 2
//        Callable<Void> task2 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                numberArray.add(i);
//            }
//            return null;
//        };
//
//        // Submit tasks and wait for completion
//        Future<Void> future1 = executorService.submit(task1);
//        Future<Void> future2 = executorService.submit(task2);
//
//        // Wait for both tasks to complete
//        future1.get();
//        future2.get();
//
//        // Shutdown the executor
//        executorService.shutdown();
//
//        // Print result
//        System.out.println("Total size: " + numberArray.size());
//    }
//}
//package santos.concurrent;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//public class ConcurrentTestOne {
//    public static void main(String[] args) throws Exception {
//        // Thread-safe list
//        List<Integer> numberArray = Collections.synchronizedList(new ArrayList<>());
//
//        // Define Runnable tasks
//        Runnable task1 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                numberArray.add(i);
//            }
//        };
//
//        Runnable task2 = () -> {
//            for (int i = 0; i < 1000; i++) {
//                numberArray.add(i);
//            }
//        };
//
//        // Run both tasks asynchronously using common ForkJoinPool
//        CompletableFuture<Void> future1 = CompletableFuture.runAsync(task1);
//        CompletableFuture<Void> future2 = CompletableFuture.runAsync(task2);
//
//        // Wait for both to complete
//        CompletableFuture.allOf(future1, future2).join();
//
//        // Output final size
//        System.out.println("Total size: " + numberArray.size());
//    }
//}
package santos.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentTestOne {
    public static void main(String[] args) throws Exception {
        // Thread-safe list
//        List<Integer> numberArray = Collections.synchronizedList(new ArrayList<>());
          List<Integer> numberArray = new ArrayList<>();
        // Custom executor service with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Task 1
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                numberArray.add(i);
            }
        };

        // Task 2
        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                numberArray.add(i);
            }
        };

        // Submit tasks using CompletableFuture and custom executor
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(task1, executorService);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(task2, executorService);

        // Wait for both tasks to complete
        CompletableFuture.allOf(future1, future2).join();

        // Shutdown the executor
        executorService.shutdown();

        // Output result
        System.out.println("Total size: " + numberArray.size());
    }
}
