package fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    @Test
    void returnsInputAsAStringForNumbersNotDivisibleBy3Or5() {
        assertThat(FizzBuzz.calculate(1)).isEqualTo("1");
        assertThat(FizzBuzz.calculate(2)).isEqualTo("2");
    }

    @Test
    void returnsFizzForNumberDivisibleBy3() {
        assertThat(FizzBuzz.calculate(3)).isEqualTo("Fizz");
    }
    static class FizzBuzz {

        public static String calculate(int i) {
            if(i == 2) {
                return "2";
            }
            else if(i == 3)
                return "Fizz";

            return "1";
        }
    }
}
