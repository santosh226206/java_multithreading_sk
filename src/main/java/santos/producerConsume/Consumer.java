////package santos.producerConsume;
////
////public class Consumer extends Thread{
////    SharedResource res;
////    Consumer(SharedResource sh){
////        this.res=sh;
////    }
////
////    @Override
////    public void run() {
////        if(this.res.sharedResourceSize()!=0){
////            while(this.res.sharedResourceSize()!=0){
////                System.out.println(this.res.consume());
////                System.out.println("element-consumed");
////            }
////            this.res.notify();
////        } else{
////            try {
////                this.res.wait();
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////        }
////    }
////}
//package santos.producerConsume;
//
//public class Consumer extends Thread {
//    SharedResource res;
//
//    Consumer(SharedResource sh) {
//        this.res = sh;
//    }
//
//    @Override
//    public void run() {
//        try {
//                res.consume();
//                System.out.println("Consumed: " );
//                //Thread.sleep(800);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
package santos.producerConsume;

public class Consumer extends Thread {
    SharedResource res;

    Consumer(SharedResource sh) {
        this.res = sh;
    }

    @Override
    public void run() {
        try {
            while (true) { // infinite loop
                res.consume();
                Thread.sleep(800); // slow down consumption
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
