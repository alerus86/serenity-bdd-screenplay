package serenity.bdd.automation.framework.stepdefinitions.general;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import serenity.bdd.automation.framework.datatypes.UserData;

import static serenity.bdd.automation.framework.util.general.Constants.ENGLISH;

public class BaseSetUp {

    protected static UserData userData;

    public EnvironmentSpecificConfiguration Env = EnvironmentSpecificConfiguration.from(Serenity.environmentVariables());

    public String getEnv(String... args) {

        String EnvURL = "";

        EnvURL = EnvURL.isBlank() ? Env.getProperty("env" + String.join(".", args))
                : EnvURL + (args[1].equals(ENGLISH) ? "?lang=en" : "?lang=es");
        return EnvURL;
    }
}
