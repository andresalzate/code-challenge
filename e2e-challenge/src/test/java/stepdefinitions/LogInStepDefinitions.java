package stepdefinitions;

import actions.LogInSteps;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import actions.NavigateSteps;
import net.serenitybdd.core.Serenity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LogInStepDefinitions {

    @Steps
    NavigateSteps navigate;
    @Steps
    LogInSteps login;

    @Given("^(?:.*) with valid credentials")
    public void userWithValidCredentials() {
        navigate.opensTheIndexPage();
    }

    @When("^she|he logs in")
    public void logIn() {
        login.searchForTerm("testuser", "testpassword");
    }

    @Then("^she|he should see the main page")
    public void shouldSeeMainPage() {
        assertThat(login.getUrl()).matches("https://demo.applitools.com/hackathonAppV2.html");
        assertThat(login.getTitle()).matches("ACME demo app");
    }
}
