package serenity.bdd.automation.framework.enumerables;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Language {

    LANGUAGE("English", "Spanish");

    private final String english;
    private final String spanish;
}
