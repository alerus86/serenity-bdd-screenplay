package serenity.bdd.automation.framework.builder;

public class TheAlertMsgIs {

    private String language;
    private String flow;

    public TheAlertMsgIs forThe(String flow) {

        this.flow = flow;
        return this;
    }
}
