package mybelly.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mybelly.Belly;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BellyCukesSteps {
    private Belly belly;
    private int waitingTime;

    @Given("^I have (\\d+) (?:cuke|cukes) in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        belly = new Belly();
        belly.eatCukes(cukes);
    }

    @When("^I wait (\\d+) hour$")
    public void I_wait_hour(int waitingTime) throws Throwable {
        this.waitingTime = waitingTime;
    }

    @Then("^My belly should (?:be )?\"([^\"]*)\"$")
    public void my_belly_should(String expectedSound) throws Throwable {
        String actualSound = belly.getSound(waitingTime);
        assertThat(actualSound, is(expectedSound));
    }

    @When("^I don't wait$")
    public void I_don_t_wait() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
