package santos.concurrentLocks;

public class Consumer extends Thread {
    SharedResource res;

    Consumer(SharedResource sh) {
        this.res = sh;
    }

    @Override
    public void run() {
        try {
            while (true) {
                res.consume();
                Thread.sleep(800); // simulate work
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
