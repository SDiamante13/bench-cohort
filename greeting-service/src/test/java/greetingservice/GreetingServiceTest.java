package greetingservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreetingServiceTest {

    private final RNG mockRNG = mock(RNG.class);
    private final GreetingService greetingService = new GreetingService(mockRNG);

    @Test
    void returnsASimpleGreeting() {
        String result = greetingService.getSimpleGreeting();

        assertThat(result).isEqualTo("Hello my friend!");
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|',
            value = {
                    "0|Hello Joe!",
                    "1|Hey Joe, nice to see you here!",
                    "2|Joe welcome back!",
                    "3|Have a splendid day Joe."
            })
    void returnsARandomGreeting(int randomNumber, String expectedGreeting) {
        when(mockRNG.next())
                .thenReturn(randomNumber);

        String result = greetingService.getCustomizedGreeting("Joe");

        assertThat(result).isEqualTo(expectedGreeting);
    }
}