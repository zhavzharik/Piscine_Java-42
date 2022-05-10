package edu.school21.numbers;

public class NumberWorker {

   public boolean isPrime(int number) {

        boolean isPrime = true;
        if (number <= 1) {
            throw new IllegalNumberException("number <= 1");
        }

        int numberSqrt;

        if (number > 2) {
            numberSqrt = (int) Math.sqrt(number);

            for (int i = 2; i <= numberSqrt + 1 && isPrime; i++) {
                if (number % i == 0) {
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }

    public int digitsSum(int number) {

        int result = 0;

        while (number != 0){
            result += number % 10;
            number /= 10;
        }
        return (result);
    }
}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String msg) {
        super(msg);
    }
}
