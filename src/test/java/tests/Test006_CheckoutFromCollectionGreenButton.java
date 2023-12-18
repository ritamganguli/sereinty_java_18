package tests;

import common.Application;
import common.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Story;
import net.serenitybdd.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "CheckoutDetails.csv", separator = ',')
public class Test006_CheckoutFromCollectionGreenButton extends BaseTest {

    @Steps
    public LoginSteps loginSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public CollectionsSteps collectionsSteps;
    @Steps
    public ProductDetailsSteps productDetailsSteps;
    @Steps
    public CheckoutSteps checkoutSteps;
    @Steps
    public ReviewOrderSteps reviewOrderSteps;
    @Steps
    public CartSteps cartSteps;

    String user, password, expectedProfileName, email, country, firstName, lastName, address, postalCode, city;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("Test006 - Checkout from Collection using green button")
    public void test006_CheckoutFromCollectionGreenButton() {
        loginSteps.navigateToBaseUrl();
        driver.get(getProperty(Constants.PROPERTY_BASE_URL) + Constants.COLLECTIONS_URLS.get(1));
        homePageSteps.clearCart();

        String productName = collectionsSteps.getFirstProductName();
        collectionsSteps.clickQuickAddToCartFirstProduct();
        String price = productDetailsSteps.getPrice();
        collectionsSteps.clickAddToCart();

        productDetailsSteps.clickViewCart();

        cartSteps.editProductQuantity("1");
        cartSteps.clickCheckout();

        checkoutSteps.completeCheckout(email, country, firstName, lastName, address, postalCode, city);
        reviewOrderSteps.verifyProduct(productName);
        reviewOrderSteps.verifyPrice(price);

    }
} 