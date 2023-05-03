package serenity.bdd.automation.framework.exceptions;

import java.util.NoSuchElementException;

import static java.lang.String.format;

public class NoJSONDataException extends NoSuchElementException {

    public NoJSONDataException(String user, String jsonFilePath) {

        super(format("\n%s\nThe user '%s' is not present in the file: \n%s\n%s", "=".repeat(50), user, jsonFilePath, "=".repeat(50)));
    }
}
