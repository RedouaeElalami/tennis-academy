package cucumber_SpringBoot;

import com.zenika.academy.tennisacademy.domain.Player;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MyStepdefsNewPlayer extends SpringIntegrationTest {
    private ResponseEntity<List> playerResponseEntity;
    private ResponseEntity<Player> playerResponseEntity1;
    private static int oldSize;
    private static int newSize;

    @Given("^the size of players is (\\d+)$")
    public void theSizeOfPlayersIs(int oldSize) {
        playerResponseEntity = restTemplate.getForEntity("http://localhost:8080/players/", List.class);
        int numberOfPlayers = playerResponseEntity.getBody().size();
//        Assertions.assertThat(numberOfPlayers).isEqualTo(oldSize);
    }

    @When("^add a new player$")
    public void addANewPlayer() {
        Player player = new Player();
        player.setName("redouane elalami");
        player.setAge(26);
        playerResponseEntity1 = restTemplate.postForEntity("http://localhost:" + port + "/ajouterJoueur", player, Player.class);
    }

    @Then("^size of players is (\\d+)$")
    public void sizeOfPlayersIs(int newSize) {
        playerResponseEntity = restTemplate.getForEntity("http://localhost:8080/players/", List.class);
        int numberOfPlayers = playerResponseEntity.getBody().size();
        System.out.println("numberOfPlayers = " + numberOfPlayers);
        Assertions.assertThat(numberOfPlayers).isEqualTo(newSize);
    }
}
