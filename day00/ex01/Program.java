import java.util.Scanner;

public class Program {

    private static int calcSqrt(int inputNumber) {

        long begin = 1;

        long end = inputNumber;

        long middle;

        long result = 0;

        while (begin <= end) {
            middle = (begin + end) / 2;
            if (middle * middle == inputNumber) {
                return ((int) middle);
            } else if (middle * middle < inputNumber) {
                begin = middle + 1;
                result = middle;
            } else {
                end = middle - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int inputNumber = sc.nextInt();

        if (inputNumber <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        boolean isPrime = true;

        int countSteps = 0;

        int numberSqrt;

        if (inputNumber == 2) {
            System.out.println(isPrime + " " + 1);
        } else {
            numberSqrt = calcSqrt(inputNumber);
            for (int i = 2; i <= numberSqrt + 1 && isPrime; i++) {
                countSteps++;
                if (inputNumber % i == 0) {
                    isPrime = false;
                }
            }
            System.out.println(isPrime + " " + countSteps);
        }
    }
}