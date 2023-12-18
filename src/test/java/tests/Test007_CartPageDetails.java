package tests;

import common.Application;
import common.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Story;
import net.serenitybdd.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "CheckoutDetails.csv", separator = ',')
public class Test007_CartPageDetails extends BaseTest {

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
    @Title("Test007 - Verify details of added product on the Cart Page")
    public void test007_CartPageDetails() {
        loginSteps.navigateToBaseUrl();
        driver.get(getProperty(Constants.PROPERTY_BASE_URL) + Constants.COLLECTIONS_URLS.get(1));
        homePageSteps.clearCart();

        String productName = collectionsSteps.getFirstProductName();
        collectionsSteps.clickQuickAddToCartFirstProduct();
        String price = productDetailsSteps.getPrice();

        collectionsSteps.clickAddToCart();

        productDetailsSteps.clickViewCart();

        String productNameOnCartPage = cartSteps.getProductName();
        String qtyOnCartPage = cartSteps.getProductQuantity();
        String priceOnCartPage = cartSteps.getPrice();
        String totalValueOnCartPage = cartSteps.getTotalValue();

        Assert.assertTrue("Product Name on Cart page is not equal to the product name. " +
                "Expected: " + productName + " but on page was: " + productNameOnCartPage,
                productNameOnCartPage.contentEquals(productName));
        Assert.assertTrue("Price on Cart page is not equal to the product price. " +
                "Expected: " + price + " but on page was: " + priceOnCartPage, price.contentEquals(priceOnCartPage));
        Assert.assertTrue("Total value on Cart page is not equal to the product price. " +
                "Expected: " + price.replace("€", "") + " but on page was: " + totalValueOnCartPage,
                price.replace("€", "").contentEquals(totalValueOnCartPage));
        Assert.assertTrue("Product quantity should be 1. On Cart page it was: " + qtyOnCartPage,
                qtyOnCartPage.contentEquals("1"));

        cartSteps.editProductQuantity("1");
        cartSteps.clickCheckout();

        checkoutSteps.completeCheckout(email, country, firstName, lastName, address, postalCode, city);
        reviewOrderSteps.verifyProduct(productName);
        reviewOrderSteps.verifyPrice(price);

    }
} 