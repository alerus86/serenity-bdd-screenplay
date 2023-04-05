package serenity.bdd.automation.framework.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.questions.targets.TheTarget.textOf;
import static serenity.bdd.automation.framework.ui.CheckoutPage.ERROR_MESSAGE_MSG;
import static serenity.bdd.automation.framework.ui.CheckoutPage.ERROR_MESSAGE_TXT;
import static serenity.bdd.automation.framework.util.general.Constants.CHECKOUT;
import static serenity.bdd.automation.framework.util.general.Messages.isCheckoutMsg;
import static serenity.bdd.automation.framework.util.general.Utils.messageIsDisplayedInSerenityReport;

public class TheCheckoutMsg2 implements Question<Boolean> {

    private final String language;
    private final Boolean message;
    private String flow;
    private Boolean result = false;

    public TheCheckoutMsg2(String language, String flow, Boolean message) {

        this.language = language;
        this.flow = flow;
        this.message = message;
    }

    public TheCheckoutMsg2 forThe(String flow) {
        this.flow = flow;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        switch (flow) {
            case CHECKOUT:
                return checkoutModalMsg(actor);
        }
        return null;
    }

    private Boolean checkoutModalMsg(Actor actor) {

        result = actor.asksFor(textOf(ERROR_MESSAGE_TXT)).contains(isCheckoutMsg());

        messageIsDisplayedInSerenityReport(ERROR_MESSAGE_MSG);
        return result;
    }
}
