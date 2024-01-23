package stepdefinitions;

import io.cucumber.java.Before;
import io.restassured.response.Response;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.BaseStep;

public class Hooks {

    private EnvironmentVariables env;

    @Before
    public void setUp() throws Exception {
        BaseStep.properties = EnvironmentSpecificConfiguration.from(env);
        BaseStep.init();
    }
}
