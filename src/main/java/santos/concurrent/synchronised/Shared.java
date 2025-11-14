package santos.concurrent.synchronised;

public class Shared {
   public  synchronized void  cmn(){
        System.out.println("inside common");
       try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
   public synchronized void ncmn(){
       System.out.println("inside non-common");
       try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
}
