package santos.concurrent.lockTest;

public class ReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedHashMapWithReadWriteLock sharedMap = new SynchronizedHashMapWithReadWriteLock();

        // Create a writer thread
        Thread writerThread1 = new Thread(() -> {
            sharedMap.put("key1", "value1");
        }, "Writer-1");

        // Create a second writer thread that will be blocked
        Thread writerThread2 = new Thread(() -> {
            sharedMap.put("key2", "value2");
        }, "Writer-2");

        // Create multiple reader threads
        Runnable readerTask = () -> {
            System.out.println("Reading 'key1': " + sharedMap.get("key1"));
        };

        Thread readerThread1 = new Thread(readerTask, "Reader-1");
        Thread readerThread2 = new Thread(readerTask, "Reader-2");
        Thread readerThread3 = new Thread(readerTask, "Reader-3");
        
        // Start all threads
        writerThread1.start();
        readerThread1.start();
        readerThread2.start();
        
        // Let's check the concurrency rules. The second writer should be blocked
        // and the readers can run together (after the first writer is done).
        // The second writer will have to wait for both writer 1 and all readers.
        //Thread.sleep(100); // Give writer1 a head start
        writerThread2.start();
        readerThread3.start();

        // Wait for all threads to finish
        writerThread1.join();
        writerThread2.join();
        readerThread1.join();
        readerThread2.join();
        readerThread3.join();

        System.out.println("\nFinal Map Content: " + sharedMap.get("key2"));
    }
}
