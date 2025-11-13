package santos.executorService;

public class SquarinTest {
    public static void main(String[] args) {
        SqureOfNumbers squreOfNumbers = new SqureOfNumbers();
        squreOfNumbers.funcSquareNumbers();
        System.out.println("main-method ended (executor service still running).");
    }
}
