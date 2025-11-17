package santos.concurrent.synchronised;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedLock {
    Lock lock=new ReentrantLock();
    void comn(){
        lock.lock();
        System.out.println("inside common");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    void ncomn(){
        lock.lock();
        System.out.println("inside non-common");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
