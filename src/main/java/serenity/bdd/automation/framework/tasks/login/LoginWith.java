package serenity.bdd.automation.framework.tasks.login;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

@AllArgsConstructor
public class LoginWith implements Task {

    private final String user;
    private final String pass;

    /*public static LoginWithBuilder theUsername(String user) {

        return new LoginWithBuilder(user);
    }*/

    @Override
    @Step("{0} login with the user #user")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(PartialLogin.logsInWithTheUserAndPass(user, pass));
    }

    /*@AllArgsConstructor
    public static class LoginWithBuilder {

        private final String user;

        public Performable andThePass(String pass) {
            return Instrumented.instanceOf(LoginWith.class).withProperties(user, pass);
        }
    }*/
}
