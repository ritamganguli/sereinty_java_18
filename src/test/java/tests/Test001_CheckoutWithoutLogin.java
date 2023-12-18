package tests;

import common.Application;
import common.Constants;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Story;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "CheckoutDetails.csv", separator=',')
public class Test001_CheckoutWithoutLogin extends BaseTest {

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
    @Title("Test001 - Checkout without login")
    public void test001_CheckoutWithoutLogin() {
        loginSteps.navigateToBaseUrl();
        homePageSteps.clearCart();
        homePageSteps.clickCoffeeCollection();
        if (homePageSteps.isMobile()) {
            homePageSteps.clickTypesOfCoffee();
        }
        homePageSteps.clickEspresso();
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