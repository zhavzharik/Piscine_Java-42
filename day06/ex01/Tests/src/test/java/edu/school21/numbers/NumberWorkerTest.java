package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

    NumberWorker nw;

    @BeforeEach
    void beforeEachMethod() {
        nw = new NumberWorker();
    }

    @DisplayName("I'm isPrimeForPrimes")
    @ParameterizedTest
    @ValueSource(ints = {7, 811, 631, 997, 2, 3})
    void isPrimeForPrimes(int argument) {
        Assertions.assertTrue(nw.isPrime(argument));
    }

    @DisplayName("I'm isPrimeForNotPrimes")
    @ParameterizedTest
    @ValueSource(ints = {8, 222, 666, 1000, 4, 16})
    void isPrimeForNotPrimes(int argument) {
        Assertions.assertFalse(nw.isPrime(argument));
    }

    @DisplayName("I'm isPrimeForIncorrectNumbers")
    @ParameterizedTest
    @ValueSource(ints = {-8, -222, 1, 0, -90})
    void isPrimeForIncorrectNumbers(int argument) {
        Assertions.assertThrows(IllegalNumberException.class, () -> nw.isPrime(argument));
    }

    @DisplayName("I'm checkDigitSum")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void checkDigitsSum(int number, int expected) {
        Assertions.assertEquals(nw.digitsSum(number), expected);
    }
}
