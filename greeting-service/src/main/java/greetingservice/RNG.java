package greetingservice;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RNG {

    private final Random random = new Random();

    public int next() {
        return random.nextInt(4);
    }
}
