package serenity.bdd.automation.framework.util.general;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;
import static serenity.bdd.automation.framework.util.general.Constants.ENGLISH;

public class Utils {

    public static WebDriver driver = getProxiedDriver();

    public static boolean isThePageLanguageInEnglish() {
        return thePageLanguageIs().equals(ENGLISH);
    }

    public static String thePageLanguageIs() {
        return Serenity.getCurrentSession().get("language").toString();
    }

    public static void messageIsDisplayedInSerenityReport(Target target) {

        Serenity.recordReportData()
                .withTitle("Messages")
                .andContents(theActorInTheSpotlight()
                        .asksFor(TheTarget.textOf(target)));
    }
}
