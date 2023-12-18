package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CollectionsPage extends BasePage {

    @FindBy(css = "#ProductGridContainer #product-grid li:first-child a[id *= 'CardLink']")
    private WebElement firstProduct;

    @FindBy(css = "#ProductGridContainer #product-grid li:first-child button[id *= 'quick-add']")
    private WebElement firstProductQuickAddToCartButton;

    @FindBy(css = "input[name = 'package_size']")
    private  List<WebElement> productSizes;

    @FindBy(css = "input:not([class*='disabled'])[name = 'package_size']")
    private  List<WebElement> productSizesEnabled;

    @FindBy(css = "button[id *= 'ProductSubmitButton']")
    private  WebElement addToCartButton;

    @FindBy(css = "div.sub-filter.sub-filter--1 button.sub-filter-option:nth-of-type(1)")
    private WebElement firstSubFilter;

    public String clickFirstProduct() {
        element(firstProduct).waitUntilVisible();
        scrollIntoView(firstProduct);
        String productName = firstProduct.getText().trim();
        firstProduct.click();
        return productName;
    }

    public String getFirstProductName() {
        element(firstProduct).waitUntilVisible();
        return firstProduct.getText().trim();
    }

    public void clickQuickAddToCartFirstProduct() {
        element(firstProductQuickAddToCartButton).waitUntilVisible();
        scrollIntoView(firstProductQuickAddToCartButton);
        firstProductQuickAddToCartButton.click();
    }

    public void editDetailsForQuickAddedProduct() {
        element(addToCartButton).waitUntilVisible();
        waitABit(2000);
        if(productSizesEnabled.size() > 1) {
            scrollIntoView(productSizesEnabled.get(1));
            waitABit(1000);
            jsClick(productSizesEnabled.get(1));
        }
        waitABit(2000);
    }

    public void clickAddToCart() {
        element(addToCartButton).waitUntilVisible();
        scrollIntoView(addToCartButton);
        waitABit(2000);
        addToCartButton.click();
        waitABit(3000);
    }
}
