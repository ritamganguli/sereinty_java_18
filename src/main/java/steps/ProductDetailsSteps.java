package steps;

import net.serenitybdd.annotations.Step;
import pages.ProductDetailsPage;

public class ProductDetailsSteps extends BasePageSteps {
    private static final long serialVersionUID = 1L;

    ProductDetailsPage productDetailsPage;


    @Step()
    public void clickAddToCart() {
        productDetailsPage.clickAddToCart();
    }

    @Step()
    public String getPrice() {
        return productDetailsPage.getPrice();
    }

    @Step()
    public void clickCheckout() {
        productDetailsPage.clickCheckout();
    }

    @Step()
    public void clickViewCart() {
        productDetailsPage.clickViewCart();
    }

    @Step("Change the product quantity to: {0}")
    public void editProductQuantity(String qty) {
        productDetailsPage.editProductQuantity(qty);
    }
}
