package santos.runnable;

public class ThreadTestTwo {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
           int n=10;
           try{
               System.out.println(n/0);
           } catch (Exception e) {
               System.out.println(e);
           }

        });
        thread.start();
    }
}
