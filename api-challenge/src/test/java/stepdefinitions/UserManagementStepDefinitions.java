package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.UserCreationResponse;
import dto.UserInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import steps.UserSteps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserManagementStepDefinitions {

    private String name, job;
    @Steps
    UserSteps userSteps;

    @Given("User who his name is {} and his job is {}")
    public void sortTransactionsByStatus(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @When("Admin tries to create the new user")
    public void createNewUser() throws JsonProcessingException {

        userSteps.insertNewUser(name, job);
    }

    @Then("User should be created successful")
    public void userCreated() throws JsonProcessingException {

        restAssuredThat(response -> response.statusCode(201));
        restAssuredThat(response -> response.body( JsonSchemaValidator.matchesJsonSchemaInClasspath(
                "schemas/user-created-response.json")));

        UserInfo userInfo = userSteps.getUser(((UserCreationResponse)Serenity.sessionVariableCalled("userCreationResponse")).getId());

        restAssuredThat(response -> response.body("results", hasSize(greaterThan(0))));
        restAssuredThat(response -> response.statusCode(200));
        assertThat(userInfo.getData().getId(), equalTo(userInfo.getData().getId()));
    }
}
