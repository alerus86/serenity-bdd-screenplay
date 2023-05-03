package serenity.bdd.automation.framework.runners.login;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login/login.feature",
        glue = {"serenity/bdd/automation/framework/stepdefinitions/login",
                "serenity/bdd/automation/framework/stepdefinitions/general"},
        plugin = "pretty")

public class LoginRunner {
}
