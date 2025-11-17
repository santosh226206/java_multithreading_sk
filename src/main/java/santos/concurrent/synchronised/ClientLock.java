package santos.concurrent.synchronised;

public class ClientLock {
    public static void main(String[] args) {
        SharedLock sharedLock=new SharedLock();
        Thread thread1=new Thread(()->{
            System.out.println("inside thread 1");
            sharedLock.comn();
        });
        Thread thread2= new Thread(()->{
            System.out.println("inside thread 2");
            sharedLock.ncomn();
        });
        thread1.start();
        thread2.start();
        System.out.println("main ended");
    }
}
