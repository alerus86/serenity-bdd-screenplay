package serenity.bdd.automation.framework.stepdefinitions.general;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import serenity.bdd.automation.framework.datatypes.UserData;
import serenity.bdd.automation.framework.util.datareader.JsonDataReader;

import static serenity.bdd.automation.framework.util.general.Constants.USER;

public class BaseSetUp {

    protected static UserData userData;

    public EnvironmentSpecificConfiguration Env = EnvironmentSpecificConfiguration.from(Serenity.environmentVariables());

    public String getEnv(String... args) {

        String EnvURL = Env.getOptionalProperty("QA_URL").orElse("");

        EnvURL = EnvURL.isBlank() ? Env.getProperty("env." + String.join(".", args))
                : null;
        return EnvURL;
    }

    public void prepareUserDataFor(String user) {
        userData = JsonDataReader.userData(USER, user);
    }
}
