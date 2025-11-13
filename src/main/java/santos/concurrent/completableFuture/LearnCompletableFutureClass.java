package santos.concurrent.completableFuture;

import java.util.concurrent.CompletableFuture;

public class LearnCompletableFutureClass {
    public static void main(String[] args) throws Exception{
        CompletableFuture<Integer> objOfCompletableFuture = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        // Asynchronous tasks

        objOfCompletableFuture.thenApplyAsync(result -> {
            return result + 10;
        })
        .thenApplyAsync(result -> {
            return result * 100;
        })
        .thenAccept(result -> {
            System.out.println(result);
        });
        System.out.println("main ended");
    }
}