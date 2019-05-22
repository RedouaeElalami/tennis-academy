package cucumber_SpringBoot;

import com.zenika.academy.tennisacademy.domain.Player;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.http.ResponseEntity;

public class MyStepdefsPlayer extends SpringIntegrationTest {

    private ResponseEntity<Player> playerResponseEntity;

    @When("^call /players/(\\d+)$")
    public void callPlayers(int playerId) throws Throwable {
      //  executeGet("http://localhost:8080/players/" + playerId);
        playerResponseEntity = restTemplate.getForEntity("http://localhost:8080/players/" + playerId, Player.class);
    }

    @Then("^the client receives name of this player is \"([^\"]*)\" and his age is (\\d+)$")
    public void theClientReceivesNameOfThisPlayerIsAndHisAgeIs(String playerName, int age) throws Throwable {
        Player player = playerResponseEntity.getBody();
        Assertions.assertThat(player.getName()).isEqualTo(playerName);
        Assertions.assertThat(player.getAge()).isEqualTo(age);
    }
}
