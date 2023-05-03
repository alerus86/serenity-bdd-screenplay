package serenity.bdd.automation.framework.util.datareader;

import com.google.gson.Gson;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import serenity.bdd.automation.framework.datatypes.UserData;
import serenity.bdd.automation.framework.exceptions.NoJSONDataException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import static serenity.bdd.automation.framework.util.general.Constants.QA;

public class JsonDataReader {

    private static String jsonFilePath;

    private static String loadJSON(String JSONFile) {

        EnvironmentSpecificConfiguration serenityConf = EnvironmentSpecificConfiguration.from(Serenity.environmentVariables());
        String Environment = Serenity.getCurrentSession().getOrDefault("environment", QA).toString();
        String jsonFileRootPath = serenityConf.getProperty("testDataResourcePath");
        jsonFileRootPath = Environment.equals(QA) ? jsonFileRootPath : jsonFileRootPath.replace("/jsonfiles", "/" + Environment);

        return jsonFilePath = jsonFileRootPath + JSONFile + ".json";
    }

    public static UserData userData(String file, String user) {

        Gson gson = new Gson();
        UserData[] userData;
        BufferedReader bufferReader = null;

        try {
            bufferReader = new BufferedReader(new FileReader(loadJSON(file)));
            userData = gson.fromJson(bufferReader, UserData[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + jsonFilePath);
        } finally {
            try {
                if (bufferReader != null) bufferReader.close();

            } catch (IOException ignore) {
            }
        }
        return Arrays.stream(userData)
                .filter(x -> x.username.equalsIgnoreCase(user))
                .findAny().orElseThrow(() -> new NoJSONDataException(user, jsonFilePath));
    }
}
