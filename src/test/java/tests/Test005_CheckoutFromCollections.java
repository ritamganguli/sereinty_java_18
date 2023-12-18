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
@UseTestDataFrom(value = Constants.BASE_DIR + "CheckoutDetails.csv", separator=',')
public class Test005_CheckoutFromCollections extends BaseTest {

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

	String user, password, expectedProfileName, email,country,firstName,lastName,address,postalCode,city;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("Test005 - Checkout from Collections pages")
    public void test005_CheckoutFromCollections() {
        loginSteps.navigateToBaseUrl();
        for(String collectionUrl : Constants.COLLECTIONS_URLS) {
            driver.get(getProperty(Constants.PROPERTY_BASE_URL) + collectionUrl);
            homePageSteps.clearCart();
            String productName = collectionsSteps.clickFirstProduct();
            String price = productDetailsSteps.getPrice();
            productDetailsSteps.clickAddToCart();
            productDetailsSteps.clickCheckout();
            checkoutSteps.verifyOnCheckoutPage();
            checkoutSteps.completeCheckout(email,country,firstName,lastName,address,postalCode,city);
            reviewOrderSteps.verifyProduct(productName);
            reviewOrderSteps.verifyPrice(price);
        }
    }
} 