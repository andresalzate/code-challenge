package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public static final By TRANSACTIONS = By.cssSelector("#transactionsTable > tbody > tr");
    public static final By TRANSACTION_STATUS = By.cssSelector(".nowrap:first-child > span:last-child");
    public static final By TRANSACTION_DATE = By.cssSelector("td:nth-child(2)");
    public static final By TRANSACTION_DESCRIPTION = By.cssSelector("td:nth-child(3)");
    public static final By TRANSACTION_CATEGORY = By.cssSelector(".badge");
    public static final By TRANSACTION_VALUE = By.cssSelector(".text-right > span");
    public static final By TOTAL_BALANCE = By.cssSelector("#totalBalance > .balance-value > span:first-child");
    public static final By CREDIT_AVAILABLE = By.cssSelector("#creditAvailable > .balance-value");
    public static final By STATUS_COLUMN = By.id("status");
}
