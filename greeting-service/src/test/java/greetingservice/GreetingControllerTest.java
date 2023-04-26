package greetingservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class GreetingControllerTest {

    private final GreetingService mockGreetingService = mock(GreetingService.class);
    private final GreetingController greetingController = new GreetingController(mockGreetingService);

    @Test
    void shouldReturnASimpleGreeting() {
        when(mockGreetingService.getSimpleGreeting())
                .thenReturn("Hello my friend!");

        ResponseEntity<String> actualResponse = greetingController.simpleGreeting(null);

        assertThat(actualResponse.getBody()).isEqualTo("Hello my friend!");
    }

    @Test
    void shouldReturnACustomizedGreeting() {
        when(mockGreetingService.getCustomizedGreeting("Paul"))
                .thenReturn("Hello Paul!");

        ResponseEntity<String> actualResponse = greetingController.simpleGreeting("Paul");

        assertThat(actualResponse.getBody()).isEqualTo("Hello Paul!");
    }
}
