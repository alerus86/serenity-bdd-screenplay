package serenity.bdd.automation.framework.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.Select;

@AllArgsConstructor
public class SearchByPartialVisibleTextFromTarget implements Interaction {

    private Target target;
    private String value;

    @Step("{0} searches a value in a list by partial text")
    public <T extends Actor> void performAs(T actor) {

        Select select = new Select(target.resolveFor(actor));
        select.getOptions().stream().filter(option -> option.getText()
                        .toLowerCase().contains(value.toLowerCase()))
                .findFirst().ifPresent(option -> select.selectByValue(option.getAttribute("value")));
    }

}
