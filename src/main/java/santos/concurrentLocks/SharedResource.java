package santos.concurrentLocks;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final Stack<Integer> stk = new Stack<>();
    private final int CAPACITY = 2;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    // Producer produces ONE item at a time
    public void produce(int ele) throws InterruptedException {
        lock.lock();
        try {
            while (stk.size() == CAPACITY) {
                notFull.await(); // wait if full
            }
            stk.push(ele);
            System.out.println("Produced: " + ele);
            notEmpty.signal(); // wake up one consumer
        } finally {
            lock.unlock();
        }
    }

    // Consumer consumes ONE item at a time
    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (stk.isEmpty()) {
                notEmpty.await(); // wait if empty
            }
            int val = stk.pop();
            System.out.println("Consumed: " + val);
            notFull.signal(); // wake up one producer
            return val;
        } finally {
            lock.unlock();
        }
    }
}
