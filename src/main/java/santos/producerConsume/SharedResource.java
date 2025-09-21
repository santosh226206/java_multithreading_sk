////package santos.producerConsume;
////
////import java.util.Stack;
////
////public class SharedResource {
////    Stack<Integer> stk;
////    SharedResource(){
////        this.stk=new Stack<>();
////    }
////    void produce(int ele){
////        this.stk.push(ele);
////    }
////    int consume(){
////        return this.stk.pop();
////    }
////    int sharedResourceSize(){
////        return this.stk.size();
////    }
////
////}
//package santos.producerConsume;
//
//import java.util.Stack;
//
//public class SharedResource {
//    Stack<Integer> stk = new Stack<>();
//    private final int CAPACITY = 2;
//
//    public synchronized void produce(int ele) throws InterruptedException {
////        while (stk.size() == CAPACITY) {
////            wait(); // wait if full
////        }
////        stk.push(ele);
////        System.out.println("Produced: " + ele);
////
////        notifyAll(); // notify consumers
//        while(stk.size() == CAPACITY){
//            wait();
//        }
//        while(stk.size()<CAPACITY){
//            stk.push(ele);
//            if(stk.size()==CAPACITY){
//                notify();
//            }
//        }
//    }
//
//    public synchronized void consume() throws InterruptedException {
//        while (stk.isEmpty()) {
//            wait(); // wait if empty
//        }
////        int val = stk.pop();
////        notifyAll(); // notify producers
//        while(!stk.empty()){
//            System.out.println(stk.pop());
//            if(stk.empty()){
//                notify();
//            }
//        }
//    }
//}
package santos.producerConsume;

import java.util.Stack;

public class SharedResource {
    Stack<Integer> stk = new Stack<>();
    private final int CAPACITY = 2;

    // Producer produces ONE item at a time
    public synchronized void produce(int ele) throws InterruptedException {
        while (stk.size() == CAPACITY) {
            System.out.println("indide wait producer");
            wait(); // wait if full
        }
//        stk.push(ele);
//        System.out.println("Produced: " + ele);
//        notifyAll(); // wake up consumers
        while(stk.size()<CAPACITY){
            stk.push(ele);
            System.out.println("Produce ------"+ ele);
            if(stk.size()==CAPACITY){
                //notifyAll();
            }
        }
    }

    // Consumer consumes ONE item at a time
    public synchronized int consume() throws InterruptedException {
        while (stk.isEmpty()) {
            System.out.println("inside wait consumer");
            wait(); // wait if empty
        }
        int val = stk.pop();
        System.out.println("Consumed: " + val);
        //notifyAll(); // wake up producers
        return val;
    }
}
