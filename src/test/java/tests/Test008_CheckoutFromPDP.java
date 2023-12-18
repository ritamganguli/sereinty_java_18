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
public class Test008_CheckoutFromPDP extends BaseTest {

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

    String user, password, expectedProfileName, email, country, firstName, lastName, address, postalCode, city;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("Test008 - Checkout from PDP page")
    public void test008_CheckoutFromPDP() {
        loginSteps.navigateToBaseUrl();
        driver.get(getProperty(Constants.PROPERTY_BASE_URL) + Constants.PDP_URLS.get(0));

        homePageSteps.clearCart();
        String price = productDetailsSteps.getPrice();
        productDetailsSteps.clickAddToCart();
        productDetailsSteps.clickCheckout();
        checkoutSteps.completeCheckout(email, country, firstName, lastName, address, postalCode, city);
        reviewOrderSteps.verifyPrice(price);

    }
} 