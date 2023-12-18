package steps;

import net.serenitybdd.annotations.Step;
import pages.CollectionsPage;

public class CollectionsSteps extends BasePageSteps {
    private static final long serialVersionUID = 1L;

    CollectionsPage collectionsPage;


    @Step("Click First Product")
    public String clickFirstProduct() {
        return collectionsPage.clickFirstProduct();
    }
    @Step()
    public String getFirstProductName() {
        return collectionsPage.getFirstProductName();
    }

    @Step()
    public void clickQuickAddToCartFirstProduct() {
        collectionsPage.clickQuickAddToCartFirstProduct();
    }

    @Step()
    public void editDetailsForQuickAddedProduct() {
      collectionsPage.editDetailsForQuickAddedProduct();
    }

    @Step()
    public void clickAddToCart() {
        collectionsPage.clickAddToCart();
    }

}
