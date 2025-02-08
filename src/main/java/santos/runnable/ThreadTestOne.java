package santos.runnable;

public class ThreadTestOne {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{

            try {
                Thread.sleep(10000);
                System.out.println("hello from rhread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        t.join();
        System.out.println("programs-end");
    }
}
