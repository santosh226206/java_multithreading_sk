package santos.runnable;

public class ThreadTestTwo {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
           int n=10;
           try{
               System.out.println(n/2);
               System.out.println(Thread.currentThread().getName());
           } catch (Exception e) {
               System.out.println(e);
           }

        },"thread1");
        thread.start();
    }
}
