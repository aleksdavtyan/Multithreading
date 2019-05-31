package sharedcounter;

import ui.CommandLineUserInterface;

import java.util.LinkedList;
import java.util.List;

public class Increment {

    private static Increment incrementInstance = new Increment();

    public static Increment getIncrementInstance() {
        return incrementInstance;
    }

    private Increment() {
    }

    public void startIncrement() {
        CommandLineUserInterface commandLineUserInterface = new CommandLineUserInterface();
        commandLineUserInterface.output("Please insert the number of threads:");
        int numberOfThreads = commandLineUserInterface.readInt();

        List<SharedCounter> sharedCountersList = new LinkedList<>();
        List<Thread> threadList = new LinkedList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            SharedCounter sharedCounter = new SharedCounter(i);
            sharedCountersList.add(sharedCounter);
            threadList.add(new Thread(sharedCounter, "i"));
        }

        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < sharedCountersList.size(); i++) {
            commandLineUserInterface.output(String.format("%s-nd incremented number = %s ", i, sharedCountersList.get(i).getNumber()));
        }
    }
}
