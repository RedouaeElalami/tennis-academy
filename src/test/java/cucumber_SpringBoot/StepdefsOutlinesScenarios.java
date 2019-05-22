package cucumber_SpringBoot;

import com.zenika.academy.tennisacademy.domain.Player;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber_SpringBoot.SpringIntegrationTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

public class StepdefsOutlinesScenarios extends SpringIntegrationTest {

    private ResponseEntity<List> playerResponseEntity;

    @When("^the client calls /players/\"([^\"]*)\"$")
    public void theClientCallsPlayers(String playerId) throws Throwable {
        System.out.println("playerId = " + playerId);
        playerResponseEntity = restTemplate.getForEntity("http://localhost:8080/players/", List.class);
    }


    @Then("^the client receives Le nom de joueur \"([^\"]*)\"$")
    public void theClientReceivesLeNomDeJoueur(String name) throws Throwable {
        List<Player> players = playerResponseEntity.getBody();

        assertThat(players).extracting("name")
                .contains("Novak Djokovic",
                        "Rafael Nadal",
                        "Roger Federer",
                        "Alexander Zverev",
                        "Juan Martin del Potro");

    }



    /*@And("^the client receives L'age de joueur \"([^\"]*)\"$")
    public void theClientReceivesLAgeDeJoueur(String age) throws Throwable {
    }*/
}
