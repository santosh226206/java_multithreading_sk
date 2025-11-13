package santos.concurrent.lockTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Game {
    private final Lock trophyLock = new ReentrantLock();
    private boolean trophyHeld = false;

    public void play(String playerName) {
        System.out.println(playerName + " wants to grab the trophy.");

        // Try to acquire the lock for 1 second
        try {
            if (trophyLock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    trophyHeld = true;
                    System.out.println(playerName + " successfully grabbed the trophy!");
                    // Simulate holding the trophy for some time
                    Thread.sleep(1500);
                } finally {
                    trophyHeld = false;
                    trophyLock.unlock();
                    System.out.println(playerName + " released the trophy.");
                }
            } else {
                System.out.println(playerName + " failed to get the trophy and is taking a break.");
                // Player does something else instead of waiting
            }
        } catch (InterruptedException e) {
            System.out.println(playerName + " was interrupted while waiting for the trophy.");
        }
    }
}

public class TryLockExample {
    public static void main(String[] args) {
        Game game = new Game();

        // Player 1 tries to grab the trophy and holds it for 1.5 seconds
        Thread player1 = new Thread(() -> game.play("Player 1"));
        
        // Player 2 tries to grab the trophy after a short delay
        Thread player2 = new Thread(() -> game.play("Player 2"));

        player1.start();
        
        // Wait for player 1 to have a chance to grab the trophy
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        player2.start();
    }
}
