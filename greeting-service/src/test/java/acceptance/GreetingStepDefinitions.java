package acceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class GreetingStepDefinitions extends SpringAcceptanceTest {

    private ResultActions resultActions;

    @When("a greeting message is requested")
    public void a_greeting_message_is_requested() throws Exception {
        resultActions = mockMvc.perform(get("/greeting"));
    }

    @Then("the system will reply with {string}")
    public void the_system_will_reply_with(String greeting) throws Exception {
        resultActions
                .andExpect(content().string(greeting));
    }
}
