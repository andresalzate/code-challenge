package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

public abstract class BaseStep {

    public static EnvironmentSpecificConfiguration properties;
    protected static ObjectMapper objectMapper;

    public static void init() {
        objectMapper = new ObjectMapper();
        RestAssured.baseURI = properties.getProperty("api.base.url");
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
