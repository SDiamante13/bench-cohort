package greetingservice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private final RNG rng;

    public GreetingService(RNG rng) {
        this.rng = rng;
    }

    public String getSimpleGreeting() {
        return "Hello my friend!";
    }

    public String getCustomizedGreeting(String name) {
        List<String> greetings = List.of(
                "Hello " + name + "!",
                "Hey " + name + ", nice to see you here!",
                "" + name + " welcome back!",
                "Have a splendid day Joe.");
        return greetings.get(rng.next());
    }
}
