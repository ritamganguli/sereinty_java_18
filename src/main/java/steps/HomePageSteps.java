package steps;

import net.serenitybdd.annotations.Step;
import pages.HomePage;

public class HomePageSteps extends BasePageSteps {
    private static final long serialVersionUID = 1L;

    HomePage homePage;

    @Step()
    public void clearCart() {
        homePage.clearCart();
    }

    @Step("Click Coffee from Navigation menu")
    public void clickCoffeeCollection() {
        homePage.clickCoffeeCollection();
    }

    @Step()
    public void clickNewInShop() {
        homePage.clickNewInShop();
    }

    @Step()
    public void clickTypesOfCoffee() {
        homePage.clickTypesOfCoffee();
    }

    @Step()
    public void clickEspresso() {
        homePage.clickEspresso();
    }

    @Step()
    public void clickFilter() {
        homePage.clickFilter();
    }
}