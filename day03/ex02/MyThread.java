import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {

    static int sumOfArrayByThreads = 0;
    private int name;
    private int start;
    private int end;
    private int sum;

    public MyThread(int name, List<Integer> threadList, int start, int end){
        this.name = name;
        this.start = start;
        this.end = end;
        for (int item : threadList){
            sum += item;
        }
    }

    public static int getSumOfArrayByThreads(){
        return sumOfArrayByThreads;
    }

    private static synchronized void displayAndAddSum(int name, int start, int end, int sum){
        System.out.println("Thread " + name + ": from " + start + " to " + end + " sum is " + sum);
        sumOfArrayByThreads += sum;
    }

    @Override
    public void run(){
        displayAndAddSum(name, start, end, sum);
    }
}