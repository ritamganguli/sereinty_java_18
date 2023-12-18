package steps;

import net.serenitybdd.annotations.Step;
import pages.CartPage;

public class CartSteps extends BasePageSteps {
    private static final long serialVersionUID = 1L;

    CartPage cartPage;


    @Step()
    public String getProductName() {
        return cartPage.getProductName();
    }

    @Step()
    public String getPrice() {
        return cartPage.getPrice();
    }

    @Step()
    public String getProductQuantity() {
        return cartPage.getProductQuantity();
    }

    @Step()
    public void editProductQuantity(String qty) {
        cartPage.editProductQuantity(qty);
    }

    @Step()
    public String getTotalValue() {
        return cartPage.getTotalValue();
    }

    @Step()
    public void clickCheckout() {
        cartPage.clickCheckout();
    }
}
