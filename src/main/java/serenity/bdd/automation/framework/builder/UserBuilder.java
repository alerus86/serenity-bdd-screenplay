package serenity.bdd.automation.framework.builder;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserBuilder implements Builder<UserLogin> {

    private String username;
    private String password;

    public UserBuilder(String username) {
        this.username = username;
    }

    public static UserBuilder theUser(String username) {
        return new UserBuilder(username);
    }

    @Override
    public UserLogin build() {
        return new UserLogin(this);
    }

    public UserLogin withPassword(String password) {

        this.password = password;
        return this.build();
    }
}
