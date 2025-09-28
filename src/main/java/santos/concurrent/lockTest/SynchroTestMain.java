package santos.concurrent.lockTest;

public class SynchroTestMain {
    public static void main(String[] args) {
        SynchroTest synchroTest=new SynchroTest();
        Thread t1=new Thread(()->{
            synchroTest.mt1();
        });
        Thread t2=new Thread(()->{
           synchroTest.mt2();
        });
        t1.start();
        t2.start();
    }
}
