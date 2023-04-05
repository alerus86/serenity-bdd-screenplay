package serenity.bdd.automation.framework.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class WaitFrameAndSwitch implements Interaction {

    private Target frame;

    public static WaitFrameAndSwitch waitAndSwitch(Target frame) {

        return instrumented(WaitFrameAndSwitch.class, frame);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(ExpectedConditions
                .frameToBeAvailableAndSwitchToIt(frame.resolveFor(actor)));
        Switch.toFrame(frame.resolveFor(actor));
    }
}
