package santos.concurrent;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ConcurrentTestOne {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> numberArray=new ArrayList();
        Thread thread1=new Thread(()->{
            for(int i=0;i<1000;i++){
                numberArray.add(i);
            }
        });
        Thread thread2=new Thread(()->{
            for (int i=0;i<1000;i++){
                numberArray.add(i);
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(numberArray.size());
    }
}
