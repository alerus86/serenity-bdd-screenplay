package serenity.bdd.automation.framework.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static serenity.bdd.automation.framework.ui.CheckoutPage.ERROR_MESSAGE_MSG;
import static serenity.bdd.automation.framework.ui.CheckoutPage.ERROR_MESSAGE_TXT;
import static serenity.bdd.automation.framework.util.general.Messages.checkoutErrorMsg;
import static serenity.bdd.automation.framework.util.general.Utils.messageIsDisplayedInSerenityReport;

public class TheCheckoutMsg {

    private static Boolean result = false;

    public static Question<Boolean> checkoutErrorsMsg() {

        result = Text.of((ERROR_MESSAGE_TXT))
                .answeredBy(theActorInTheSpotlight())
                .contains(checkoutErrorMsg());

        messageIsDisplayedInSerenityReport(ERROR_MESSAGE_MSG);
        return actor -> TheCheckoutMsg.result;
    }
}
