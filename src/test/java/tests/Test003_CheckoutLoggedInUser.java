package tests;

import common.Application;
import common.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Story;
import net.serenitybdd.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "CheckoutDetails.csv", separator = ',')
public class Test003_CheckoutLoggedInUser extends BaseTest {

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
    public AccountSteps accountSteps;


    String user, password, expectedProfileName, email,country,firstName,lastName,address,postalCode,city;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("Test003 - Checkout with logged in user")
    public void test003_CheckoutLoggedInUser() {
        loginSteps.navigateToBaseUrl();

        loginSteps.login(user, password);

        homePageSteps.clickCoffeeCollection();
        if (homePageSteps.isMobile()) {
            homePageSteps.clickTypesOfCoffee();
        }
        homePageSteps.clickEspresso();
        collectionsSteps.clickFirstProduct();
        productDetailsSteps.clickAddToCart();
        productDetailsSteps.clickCheckout();
        checkoutSteps.completeCheckout(email,country,firstName,lastName,address,postalCode,city);

    }

    @After
    public void after() {
        try {
            homePageSteps.clickLogoOnCheckoutPage();
            homePageSteps.clickAccountIcon();
            accountSteps.logout();
        } catch (Exception e) {
            System.out.println("Exception in after method");
        }
    }
} 