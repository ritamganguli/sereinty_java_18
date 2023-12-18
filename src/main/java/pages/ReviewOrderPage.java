package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ReviewOrderPage extends BasePage {

    @FindBy(css = "div[aria-labelledby *='MoneyLine'] div[role='row']:last-child strong")
    private WebElement totalPrice;

    @FindBy(css = "div[aria-labelledby *='MoneyLine'] div[role='row']:first-child div:last-child")
    private WebElement subTotalPrice;

    @FindBy(css = "div[aria-labelledby *='ResourceList']")
    private WebElement productsSection;


    public void verifyPrice(String priceExpected) {
        element(subTotalPrice).waitUntilVisible();
        String priceOnPage = subTotalPrice.getText();
        priceOnPage = priceOnPage.replace("€", "").trim().toLowerCase();
        priceExpected = priceExpected.replace("€", "").trim().toLowerCase();
        Assert.assertTrue("Expected price: " + priceExpected + " but was: " + priceOnPage,
                priceOnPage.contentEquals(priceExpected));
    }

    public void verifyProduct(String productName) {
        element(productsSection).waitUntilVisible();
        String productsSectionText = productsSection.getText();
        Assert.assertTrue(productName + " was not found in the products section. Text was: " + productsSectionText,
                productsSectionText.contains(productName));
    }
}
