package arraymax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArrayMax {

    private static ArrayMax arrayMaxInstace = new ArrayMax();

    public static ArrayMax getArrayMaxInstace() {
        return arrayMaxInstace;
    }

    private ArrayMax() {
    }

    public void findArrayMax() {
        int numberOfThreads = 20;
        int numberOfElements = 1000000;
        List<Integer> maxElementsList = new ArrayList<>();

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

        //List<Integer> joinedList = new ArrayList<>();
        for (MyArray myArray : myArrayList) {
            //joinedList.addAll(myArray.getList());
            maxElementsList.add(myArray.getMax());
        }
        //System.out.println("Array with random numbers:" + joinedList);
        System.out.println("Max element of Array = " + Collections.max(maxElementsList));

//        System.out.println(System.currentTimeMillis() - initialTime);
    }
}
