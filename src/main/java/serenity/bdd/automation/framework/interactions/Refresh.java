package serenity.bdd.automation.framework.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Refresh implements Interaction {

    public static Refresh page() {
        return new Refresh();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(theActorInTheSpotlight()).getDriver();
        driver.navigate().refresh();
    }
}
