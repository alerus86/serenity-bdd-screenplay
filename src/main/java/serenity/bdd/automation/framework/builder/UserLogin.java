package serenity.bdd.automation.framework.builder;

import lombok.Getter;
import serenity.bdd.automation.framework.exceptions.UserModelCreationException;

@Getter
public class UserLogin {

    private final String username;
    private final String password;

    public UserLogin(UserBuilder builder) {

        this.username = builder.getUsername();
        this.password = builder.getPassword();
        isInvalid();
    }

    private static boolean isEmptyOrNull(String value) {
        return value == null || value.isEmpty();
    }

    private void isInvalid() {

        if (isEmptyOrNull(username)) {
            throw new UserModelCreationException(String.format("Invalid username (%s)", username));
        } else if (isEmptyOrNull(password)) {
            throw new UserModelCreationException(String.format("Invalid password (%s)", password));
        }
    }

}
