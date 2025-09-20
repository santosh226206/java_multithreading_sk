////package santos.producerConsume;
////
////
////public class Client {
////    public static void main(String[] args) {
////        SharedResource sharedResource=new SharedResource();
////        Thread producer=new Producer(sharedResource);
////        Thread consumer=new Consumer(sharedResource);
////        producer.start();
////        consumer.start();
////    }
////}
//package santos.producerConsume;
//
//public class Client {
//    public static void main(String[] args) {
//        SharedResource sharedResource = new SharedResource();
//        Thread producer = new Producer(sharedResource);
//        Thread consumer = new Consumer(sharedResource);
//
//        producer.start();
//        consumer.start();
//    }
//}
package santos.producerConsume;

public class Client {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producer = new Producer(sharedResource);
        Thread consumer = new Consumer(sharedResource);

        producer.start();
        consumer.start();
    }
}
