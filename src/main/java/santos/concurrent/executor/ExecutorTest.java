package santos.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorTest {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(1);
        executor.execute(()->{
            System.out.println("neww thred");
        });
        executor.shutdown();
        if(executor.isTerminated()){
            System.out.println("job done");
        }
        System.out.println("main thrad terminated");
    }
}
