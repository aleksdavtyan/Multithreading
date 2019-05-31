package sharedcounter;

public class SharedCounter implements Runnable {

    private int number;
    private static int couter = 5;

    public SharedCounter(int number) {
        this.number = number;
    }

    public static int getCouter() {
        return couter;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void run() {
        number += couter;
    }
}
