package serenity.bdd.automation.framework.tasks.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static serenity.bdd.automation.framework.ui.SignInPage.*;


public class PartialLogin {

    public static Performable logsInWithTheUserAndPass(String user, String pass) {

        return Task.where("{0} login with the user #user",
                Enter.theValue(user).into(USERNAME_TXT),
                Enter.theValue(pass).into(PASSWORD_TXT),
                Click.on(SIGN_IN_BTN));
    }
}
