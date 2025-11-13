package santos.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class ResourceAccess {
    private static final int MAX_AVAILABLE = 3; // Max 3 threads can access concurrently
    private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE, true); // Fair semaphore

    public void accessResource() throws InterruptedException {
        semaphore.acquire(); // Acquire a permit
        try {
            System.out.println(Thread.currentThread().getName() + " is accessing the resource.");
            Thread.sleep(2000); // Simulate resource usage
        } finally {
            semaphore.release(); // Release the permit
            System.out.println(Thread.currentThread().getName() + " has released the resource.");
        }
    }

    public static void main(String[] args) {
        ResourceAccess manager = new ResourceAccess();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    manager.accessResource();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Thread-" + i).start();
        }
    }
}