package reversetext;

import ui.CommandLineUserInterface;

import java.util.LinkedList;
import java.util.List;

public class ReverseText {

    private static ReverseText reverseTextInstance = new ReverseText();
    private ReverseText(){}

    public static ReverseText getReverseTextInstance() {
        return reverseTextInstance;
    }

    public void startReversing() {
        int numberOfThreads = 3;
        CommandLineUserInterface commandLineUserInterface = new CommandLineUserInterface();
        commandLineUserInterface.output("Please insert the text:");
        String initialString = commandLineUserInterface.readStr();
        StringBuilder stringBuilder = new StringBuilder();
        String reversedString;
        int numberOfSymbols = initialString.length();

        List<MyString> myStringList = new LinkedList<>();
        List<Thread> threadList = new LinkedList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            MyString myString = new MyString(initialString.substring(i * numberOfSymbols / numberOfThreads,
                    (i + 1) * numberOfSymbols / numberOfThreads));
            myStringList.add(myString);
            threadList.add(new Thread(myString, "i"));
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

        for (int i = myStringList.size() - 1; i >= 0; i--) {
            stringBuilder.append(myStringList.get(i).getStringBuilder());
        }
        reversedString = stringBuilder.toString();
        System.out.println(reversedString);
    }
}
