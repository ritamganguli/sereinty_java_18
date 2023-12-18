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
public class Test002_AddToCartGreenButtonWithoutLogin extends BaseTest {

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


    String user, password, expectedProfileName, email,country,firstName,lastName,address,postalCode,city;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("Test002 - Add To Cart green button without login")
    public void test002_AddToCartGreenButtonWithoutLogin() {
        loginSteps.navigateToBaseUrl();
        homePageSteps.clickCoffeeCollection();
        if (homePageSteps.isMobile()) {
            homePageSteps.clickTypesOfCoffee();
        }
        homePageSteps.clickFilter();

        collectionsSteps.clickQuickAddToCartFirstProduct();
        collectionsSteps.editDetailsForQuickAddedProduct();
        collectionsSteps.clickAddToCart();

        productDetailsSteps.editProductQuantity("1");

        productDetailsSteps.clickCheckout();
        checkoutSteps.verifyOnCheckoutPage();
        checkoutSteps.completeCheckout(email,country,firstName,lastName,address,postalCode,city);

    }
} 