package actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import pages.LoginPage;

public class NavigateSteps extends UIInteractionSteps {

    @Step("User opens the index page")
    public void opensTheIndexPage() {
        new LoginPage().open();
    }
}
