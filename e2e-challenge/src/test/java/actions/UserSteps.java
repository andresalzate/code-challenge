package actions;

import dto.FinancialInfo;
import dto.Transaction;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.ArrayList;

public class UserSteps extends UIInteractionSteps {

    @Step("Get financial info")
    public FinancialInfo getFinancialInfo() {

        FinancialInfo financialInfo = new FinancialInfo();
        ArrayList<Transaction> userTransactions = new ArrayList<>();
        ListOfWebElementFacades transactions = findAll(HomePage.TRANSACTIONS);

        for(WebElement transaction: transactions){
            Transaction userTransaction = new Transaction();
            userTransaction.setStatus(transaction.findElement(HomePage.TRANSACTION_STATUS).getText());
            userTransaction.setDate(transaction.findElement(HomePage.TRANSACTION_DATE).getText());
            userTransaction.setDescription(transaction.findElement(HomePage.TRANSACTION_DESCRIPTION).getText());
            userTransaction.setCategory(transaction.findElement(HomePage.TRANSACTION_CATEGORY).getText());
            userTransaction.setAmount(transaction.findElement(HomePage.TRANSACTION_VALUE).getText());
            userTransactions.add(userTransaction);
        }

        financialInfo.setTransactions(userTransactions);
        financialInfo.setTotalBalance(find(HomePage.TOTAL_BALANCE).getText());
        financialInfo.setCreditAvailable(find(HomePage.CREDIT_AVAILABLE).getText());

        return financialInfo;
    }

    @Step("Get transaction values")
    public ArrayList<WebElementFacade> getTransactionValues() {
        ListOfWebElementFacades transactions = findAll(HomePage.TRANSACTIONS);
        ArrayList<WebElementFacade> transactionValues = new ArrayList<>();

        transactions.forEach(transaction -> transactionValues.add(transaction.find(HomePage.TRANSACTION_VALUE)));
        return transactionValues;
    }

    @Step("Sort transactions by Status")
    public void sortTransactionByStatus() {
        find(HomePage.STATUS_COLUMN).click();
    }
}
