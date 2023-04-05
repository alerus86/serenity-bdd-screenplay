package serenity.bdd.automation.framework.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;

public class SelectFromList {

    private String value;

    public static SelectFromList byPartialVisibletext(String partialVisibleText) {

        SelectFromList selectFromList = new SelectFromList();
        selectFromList.value = partialVisibleText;
        return selectFromList;
    }

    public Performable from(Target target) {
        return new SearchByPartialVisibleTextFromTarget(target, value);
    }
}
