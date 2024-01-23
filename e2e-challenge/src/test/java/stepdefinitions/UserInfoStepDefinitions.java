package stepdefinitions;

import actions.UserSteps;
import dto.FinancialInfo;
import dto.Transaction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserInfoStepDefinitions {

    @Steps
    UserSteps userSteps;

    @When("^she|he sorts transactions by status")
    public void sortTransactionsByStatus() {
        userSteps.sortTransactionByStatus();
    }

    @Then("^she|he should see valid info in his overview")
    public void shouldSeeValidInfoOverview() {
        FinancialInfo transactions = userSteps.getFinancialInfo();
        assertThat(transactions.getTotalBalance()).matches("\\$350");
        assertThat(transactions.getCreditAvailable()).matches("\\$17,800");
        assertThat(userSteps.getTransactionValues().size()).matches(size -> size == 6, "Amount of transactions should be 6");

        for(WebElement value: userSteps.getTransactionValues()){
            if(value.getText().charAt(0) == '-')
                assertThat(value.getAttribute("class")).matches("text-danger");

            else
                assertThat(value.getAttribute("class")).matches("text-success");
        }
    }

    @Then("^she|he should see all the transactions sorted by status")
    public void shouldSeeTransactionsSortedByStatus() {
        ArrayList<Transaction> transactions = userSteps.getFinancialInfo().getTransactions();

        for(int i = 0; i<transactions.size()-1; i++){
            assertThat(transactions.get(i).getStatus().compareToIgnoreCase(transactions.get(i+1).getStatus())).matches(compare -> compare <= 0);
        }
    }
}