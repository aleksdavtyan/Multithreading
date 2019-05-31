package arraymax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyArray implements Runnable {

    private List<Integer> list = new ArrayList<>();
    private int start;
    private int end;
    private int max;
    private Random random = new Random();


    public MyArray(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Integer> getList() {
        return list;
    }

    public int getMax() {   return max;    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            list.add(random.nextInt(100)); //common add
        }
        max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
    }
}
