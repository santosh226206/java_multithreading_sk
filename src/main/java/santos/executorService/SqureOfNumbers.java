//package santos.executorService;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class SqureOfNumbers {
//    public void squaring(List<Integer> input,int index){
//        input.set(2*input.get(index),index);
//    }
//    public void funcSquareNumbers(){
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//
//        // Create an ArrayList to store the elements
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i=0;i<2000;i++){
//            list.add(i);
//        }
//
//        // Submit tasks to the executor to add elements to the list
//        for (int i = 0; i < 2000; i++) {
//            final int index = i;
//            executor.submit(() -> {
//                // Add the element to the list
//                // Note: This is not thread-safe, see below for a thread-safe solution
//                //list.add(index);
//                squaring(list,index);
//            });
//        }
//        executor.shutdown();
//
//        // Wait for all tasks to complete
//        while (!executor.isTerminated()) {
//            // Wait...
//        }
//        list.forEach((item)-> System.out.println(item));
//        System.out.println("final execution ended");
//    }
//}
package santos.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SqureOfNumbers {
    public void squaring(List<Integer> input, int index) {
        input.set(index, 2 * input.get(index)); // Fix index issue
    }

    public void funcSquareNumbers() {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Create an ArrayList to store the elements
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }

        // Submit tasks to the executor
        for (int i = 0; i < 2000; i++) {
            final int index = i;
            executor.submit(() -> squaring(list, index));
        }

        // Initiates an orderly shutdown, tasks will complete in the background
        executor.shutdown();
        list.forEach((item)-> System.out.println(item));
        list.forEach((item)-> System.out.println(item));
        list.forEach((item)-> System.out.println(item));
        list.forEach((item)-> System.out.println(item));
        System.out.println("funcSquareNumbers() execution ended (tasks still running in background).");
        list.forEach((item)-> System.out.println(item));
        list.forEach((item)-> System.out.println(item));
        list.forEach((item)-> System.out.println(item));
        list.forEach((item)-> System.out.println(item));
    }
}
