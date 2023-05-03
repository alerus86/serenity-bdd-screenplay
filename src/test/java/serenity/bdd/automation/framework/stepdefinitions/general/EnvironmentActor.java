package serenity.bdd.automation.framework.stepdefinitions.general;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.core.Serenity.getDriver;

public class EnvironmentActor {

    @Managed
    WebDriver driver;

    @Before
    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    @AfterEach
    public void clearLocalStorage() {
        ((JavascriptExecutor) getDriver())
                .executeScript("localStorage.clear()");
    }
}
