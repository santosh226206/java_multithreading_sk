package santos.executorService;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool of size 4
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Create an ArrayList to store the elements
        ArrayList<Integer> list = new ArrayList<>();

        // Submit tasks to the executor to add elements to the list
        for (int i = 0; i < 2000; i++) {
            final int index = i;
            executor.submit(() -> {
                // Add the element to the list
                // Note: This is not thread-safe, see below for a thread-safe solution
                list.add(index);
            });
        }

        // Shut down the executor
        executor.shutdown();

        // Wait for all tasks to complete
        while (!executor.isTerminated()) {
            // Wait...
        }

        // Print the size of the list
        System.out.println("List size: " + list.size());
    }
}

