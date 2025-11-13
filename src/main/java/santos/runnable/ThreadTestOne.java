package santos.runnable;

public class ThreadTestOne {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{

            try {
                Thread.sleep(10000);
                System.out.println("hello from Thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        t.join(5000);
        //t.join();
        System.out.println("programs-end");
    }
}
