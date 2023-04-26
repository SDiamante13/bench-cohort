package acceptance;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class GreetingStepDefinitions extends SpringAcceptanceTest {

    private ResultActions resultActions;
    private String greeting;

    @When("a greeting message is requested")
    public void a_greeting_message_is_requested() throws Exception {
        resultActions = mockMvc.perform(get("/greeting"))
                .andDo(print());
    }

    @Then("the system will reply with {string}")
    public void the_system_will_reply_with(String greeting) throws Exception {
        resultActions
                .andExpect(content().string(greeting));
    }

    @When("a User with the name Joe requests a greeting message")
    public void a_user_with_the_name_joe_requests_a_greeting_message() throws Exception {
        resultActions = mockMvc.perform(get("/greeting?name=Joe"))
                .andDo(print());
        greeting = resultActions.andReturn().getResponse().getContentAsString();
    }

    @Then("the system will reply with one of the following messages:")
    public void theSystemWillReplyWithOneOfTheFollowingMessages(List<String> greetingMessages) {
        assertThat(greeting).isIn(greetingMessages);
    }
}
