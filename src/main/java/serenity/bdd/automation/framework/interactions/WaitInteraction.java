package serenity.bdd.automation.framework.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class WaitInteraction implements Interaction {

    private int timeToWait;

    public static WaitInteraction waitClass(int timeToWait) {
        return instrumented(WaitInteraction.class, timeToWait);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(timeToWait);
    }
}
