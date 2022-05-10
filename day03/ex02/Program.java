import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Program {

    private static int calculateSum(List<Integer> myArray) {
        int sumOfArrayByProgram = 0;
        for (Integer item : myArray) {
            sumOfArrayByProgram += item;
        }
        return sumOfArrayByProgram;
    }

    public static void main(String[] args) throws InterruptedException {

        int size = 0;
        int count = 0;

        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")){
            System.err.println("The wrong input!");
            System.exit(-1);
        }
        try {
            size = Integer.parseInt(args[0].substring(12));
            count = Integer.parseInt(args[1].substring(15));
        } catch (NumberFormatException e){
            System.err.println("Wrong number!");
            System.exit(-1);
        }

        if (count > size) {
            System.err.println("ArraySize should be larger than threadsCount!");
            System.exit(-1);
        }

        List<Integer> myArray = new ArrayList<Integer>(size);

        for (int i=0; i < size; i++) {
            int tmp = (int) (Math.random() * 1000) + 1;
            myArray.add(tmp);
        }

        System.out.println("Sum: " + calculateSum(myArray));

        List<MyThread> programThreads = new ArrayList<MyThread>(count);
        int sizeFirstSec = size / count;
        int name = 1;
        int start = 0;
        int end = sizeFirstSec;

        for (int i=0; i < count - 1; i++){
            programThreads.add(new MyThread(name, new ArrayList<Integer>(myArray.subList(start, end)), start, end - 1));
            name += 1;
            start += sizeFirstSec;
            end += sizeFirstSec;
        }

        programThreads.add(new MyThread(name, new ArrayList<Integer>(myArray.subList(start, size)), start, size - 1));

        for (MyThread item : programThreads){
            item.start();
        }

        for (MyThread item : programThreads){
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum by threads: " + MyThread.getSumOfArrayByThreads());
    }
}