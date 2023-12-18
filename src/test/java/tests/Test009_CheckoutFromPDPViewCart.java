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
public class Test009_CheckoutFromPDPViewCart extends BaseTest {

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
    @Title("Test009 - Checkout from PDP page and View Cart")
    public void test009_CheckoutFromPDPViewCart() {
        loginSteps.navigateToBaseUrl();
        for (String productUrl : Constants.PDP_URLS) {
            driver.get(getProperty(Constants.PROPERTY_BASE_URL) + productUrl);
            homePageSteps.clearCart();

            String price = productDetailsSteps.getPrice();
            productDetailsSteps.clickAddToCart();

            productDetailsSteps.clickViewCart();

            String productNameOnCartPage = cartSteps.getProductName();
            String priceOnCartPage = cartSteps.getPrice();

            cartSteps.clickCheckout();
            checkoutSteps.completeCheckout(email, country, firstName, lastName, address, postalCode, city);
            reviewOrderSteps.verifyProduct(productNameOnCartPage);
            reviewOrderSteps.verifyPrice(priceOnCartPage);
        }
    }
} 