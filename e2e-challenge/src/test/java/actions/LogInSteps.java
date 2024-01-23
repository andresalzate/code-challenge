package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pages.LoginPage;

public class LogInSteps extends UIInteractionSteps {

    @Step("User logs in with credentials")
    public void searchForTerm(String username, String password) {
        find(LoginPage.USERNAME_FIELD).sendKeys(username);
        find(LoginPage.PASSWORD_FIELD).sendKeys(password);
        find(LoginPage.LOG_IN_BUTTON).click();
    }

    @Step("Check url page")
    public String getUrl() {
        return getDriver().getCurrentUrl();
    }
}
