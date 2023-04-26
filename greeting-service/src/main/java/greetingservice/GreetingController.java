package greetingservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public ResponseEntity<String> simpleGreeting(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.ok(getGreeting(name));
    }

    private String getGreeting(String name) {
        if (name == null) {
            return greetingService.getSimpleGreeting();
        }
        return greetingService.getCustomizedGreeting(name);
    }
}
