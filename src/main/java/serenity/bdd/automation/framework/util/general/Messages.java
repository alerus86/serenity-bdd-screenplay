package serenity.bdd.automation.framework.util.general;

import static serenity.bdd.automation.framework.util.general.Utils.isThePageLanguageInEnglish;

public class Messages {

    public static final String CHECKOUT_ERROR_EN = "";
    public static final String CHECKOUT_ERROR_SP = "";

    public static String checkoutErrorMsg() {
        return isThePageLanguageInEnglish() ? CHECKOUT_ERROR_EN : CHECKOUT_ERROR_SP;
    }

    public static String isCheckoutMsg() {
        return isThePageLanguageInEnglish() ? CHECKOUT_ERROR_EN : CHECKOUT_ERROR_SP;
    }
}
