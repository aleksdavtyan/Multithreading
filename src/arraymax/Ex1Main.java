package arraymax;

import java.util.*;

public class Ex1Main {

    public static void main(String[] args) {

        int numberOfThreads = 5;
        int numberOfElements = 100;
        List<Integer> maxElementsList = new ArrayList<>();
        int maxElement;

        List<MyArray> myArrayList = new LinkedList<>();
        List<Thread> threadList = new LinkedList<>();

        for (int i = 0; i < numberOfThreads; i++) {
            MyArray myArray = new MyArray(i * numberOfElements / numberOfThreads,
                    (i + 1) * numberOfElements / numberOfThreads);
            myArrayList.add(myArray);
            threadList.add(new Thread(myArray, "i"));
        }

//        long initialTime = System.currentTimeMillis();
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

        List<Integer> joinedList = new ArrayList<>();
        for (MyArray myArray : myArrayList) {
            joinedList.addAll(myArray.getList());
            maxElementsList.add(myArray.getMax());
        }
        System.out.println("Array with random numbers:" + joinedList);
        System.out.println("Max element of Array = " + Collections.max(maxElementsList));

//        System.out.println(System.currentTimeMillis() - initialTime);
    }

}
