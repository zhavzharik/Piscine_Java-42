import java.util.Scanner;

public class Program {

    private static int calcSum(int inputNumber){

        int result = 0;

        while (inputNumber != 0){
            result += inputNumber % 10;
            inputNumber /= 10;
        }

        return (result);
    }

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

    private static boolean isSumPrime(int numberSum) {

        boolean isPrime = true;

        int numberSqrt;

        if (numberSum <= 1){
            isPrime = false;
        }

        if (numberSum > 2) {
            numberSqrt = calcSqrt(numberSum);
            for (int i = 2; i <= numberSqrt + 1 && isPrime; i++) {
                if (numberSum % i == 0) {
                    isPrime = false;
                }
            }
        }

        return (isPrime);
    }

    public static void main(String[] args) {
        int numberSum;

        boolean isSumPrime;

        int requestCounter = 0;

        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        while (inputNumber != 42){
            numberSum = calcSum(inputNumber);
            isSumPrime = isSumPrime(numberSum);
            if (isSumPrime){
                requestCounter += 1;
            }
            inputNumber = sc.nextInt();
        }

        System.out.println("Count of coffee-request - " + requestCounter);
    }
}