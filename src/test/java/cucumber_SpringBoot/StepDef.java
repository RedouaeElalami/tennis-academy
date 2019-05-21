package cucumber_SpringBoot;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;

public class StepDef extends SpringIntegrationTest {
    @When("^the client calls /players$")
    public void the_client_calls_players() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        executeGet("http://localhost:8080/players");

    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statueCode) throws Throwable {

        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        Assertions.assertThat(currentStatusCode.value()).isEqualTo(statueCode);
        // Write code here that turns the phrase above into concrete actions
    }
}
