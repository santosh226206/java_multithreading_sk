package santos.concurrent.synchronised;

public class Client {
    public static void main(String[] args) {
        Shared shared=new Shared();
        Thread thread1= new Thread(()->{
            System.out.println("called by thread 1");
            shared.cmn();
        });
        Thread thread2=new Thread(()->{
            System.out.println("called by thread 2");
            shared.cmn();
        });
        thread1.start();
        thread2.start();
    }
}
