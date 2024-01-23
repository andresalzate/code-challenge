package steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import dto.UserCreationRequest;
import dto.UserCreationResponse;
import dto.UserInfo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.RestAssured;

public class UserSteps extends BaseStep{

    @Step("Insert new user - name: {}, job: {}")
    public void insertNewUser(String name, String job) throws JsonProcessingException {

        UserCreationRequest userCreationRequest = UserCreationRequest.builder()
                        .name(name)
                        .job(job)
                        .build();

        SerenityRest.given()
                .body(objectMapper.writeValueAsString(userCreationRequest))
                .post(properties.getProperty("user.users"));

        UserCreationResponse userCreationResponse =
                objectMapper.readValue(SerenityRest.lastResponse().body().asString(), UserCreationResponse.class);

        Serenity.setSessionVariable("userCreationResponse").to(userCreationResponse);
    }

    @Step("Get user by id: {}")
    public UserInfo getUser(String userId) throws JsonProcessingException {
        SerenityRest.given()
                .pathParam("id", userId)
                .get(properties.getProperty("user.user"));

        return objectMapper.readValue(SerenityRest.lastResponse().body().asString(), UserInfo.class);
    }
}
