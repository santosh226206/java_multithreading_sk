package santos.concurrentLocks;

public class Producer extends Thread {
    SharedResource res;
    int counter = 1;

    Producer(SharedResource sh) {
        this.res = sh;
    }

    @Override
    public void run() {
        try {
            while (true) {
                res.produce(counter++);
                Thread.sleep(500); // simulate work
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
