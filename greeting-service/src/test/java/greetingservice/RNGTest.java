package greetingservice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RNGTest {

    private final RNG rng = new RNG();

    @Test
    void returnsNumberBetweenZeroAndThree() {
        int actual = rng.next();

        assertThat(actual).isBetween(0, 3);
    }
}