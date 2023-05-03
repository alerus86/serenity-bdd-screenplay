package serenity.bdd.automation.framework.stepdefinitions.login;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import serenity.bdd.automation.framework.stepdefinitions.general.BaseSetUp;

import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;

public class LoginStepDefinitions extends BaseSetUp {

    @Given("^that (.*) accesses to Luma in the environment (.*)$")
    public void thatUserAccessesToLuma(String user, String environment) {

        prepareUserDataFor(user);
        withCurrentActor(Open.url(getEnv(environment)));
    }
}
