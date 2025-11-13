//package santos.producerConsume;
//
//public class Producer extends Thread {
//    SharedResource res;
//
//    Producer(SharedResource sh) {
//        this.res = sh;
//    }
//
//    @Override
//    public void run() {
//        try {
//
//                res.produce(1);
//                //Thread.sleep(500);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
package santos.producerConsume;

public class Producer extends Thread {
    SharedResource res;
    int counter = 1;

    Producer(SharedResource sh) {
        this.res = sh;
    }

    @Override
    public void run() {
        try {
            while (true) { // infinite loop
                res.produce(counter++);
                Thread.sleep(500); // slow down production
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
