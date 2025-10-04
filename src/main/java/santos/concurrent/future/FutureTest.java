package santos.concurrent.future;

import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Future<Integer> future=executorService.submit(()->{
            System.out.println("inside Thread");
            Thread.sleep(10000);
            return 1;
        });
        try {
            if(future.isDone())
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main finished");
        executorService.shutdown();
    }
}
