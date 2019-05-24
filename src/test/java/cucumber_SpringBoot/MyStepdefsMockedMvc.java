package cucumber_SpringBoot;

import com.zenika.academy.tennisacademy.repository.PlayerJpaRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class MyStepdefsMockedMvc {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;


    @Then("^client makes call to mocked /players the client get default players list$")
    public void client_makes_call_to_mocked_players_the_client_get_default_players_list() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        mockMvc.perform(get("/players"))
                .andExpect(content().string("[{\"id\":1,\"name\":\"Novak Djokovic\",\"age\":31},{\"id\":2,\"name\":\"Rafael Nadal\",\"age\":32},{\"id\":3,\"name\":\"Roger Federer\",\"age\":32},{\"id\":4,\"name\":\"Alexander Zverev\",\"age\":21},{\"id\":5,\"name\":\"Juan Martin del Potro\",\"age\":30}]"));

        throw new PendingException();
    }
}
