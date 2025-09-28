package santos.concurrent.lockTest;

import javax.swing.plaf.TableHeaderUI;

public class SynchroTest {
    public synchronized void mt1(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("inside sync");
    }
    public void  mt2(){
        System.out.println("inside plane");
    }
}
