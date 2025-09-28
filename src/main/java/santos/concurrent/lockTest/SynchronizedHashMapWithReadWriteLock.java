package santos.concurrent.lockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchronizedHashMapWithReadWriteLock {

    Map<String, String> syncHashMap = new HashMap<>();
    ReadWriteLock lock = new ReentrantReadWriteLock();

    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void put(String key, String value) {
        writeLock.lock();
        try {
            syncHashMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public String remove(String key) {
        writeLock.lock();
        try {
            return syncHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key) {
        readLock.lock();
        try {
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }
}
