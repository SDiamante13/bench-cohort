package acceptance;

import greetingservice.GreetingApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@CucumberContextConfiguration
@ContextConfiguration(classes = GreetingApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringAcceptanceTest {

    @Autowired
    protected MockMvc mockMvc;
}
