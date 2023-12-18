package pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage {

	@FindBy(css = "button[id *= 'ProductSubmitButton']")
	private WebElement addToCartButton;

	@FindBy(css = "product-info div.price__sale dd.price__last")
	private WebElement price;

	@FindBy(css = "product-info div.price__regular dd.price__last")
	private WebElement priceRegular;

	@FindBy(css = "#CartDrawer-Cart")
	private WebElement viewCartButton;

	@FindBy(css = "button[class *= 'quantity__button'][name='plus']")
	private WebElement quantityButtonPlus;

	@FindBy(css = "button[class *= 'quantity__button'][name='minus']")
	private WebElement quantityButtonMinus;

	@FindBy(css = "input[class='quantity__input']")
	private WebElement quantityInput;

	@FindBy(css = "div[class = 'totals'] > p.totals__subtotal-value")
	private WebElement totalValue;

	private String checkoutButtonCssSelector = "#CartDrawer-Checkout";

	public void clickAddToCart() {
		element(addToCartButton).waitUntilVisible();
		scrollIntoView(addToCartButton);
		waitABit(2000);
		addToCartButton.click();
		waitABit(3000);
	}

	public String getPrice() {
		boolean priceIsDisplayed = true;
		boolean priceRegularIsDisplayed = true;
		try {
			element(price).waitUntilVisible();
			scrollIntoView(price);
		} catch (Exception e) {
			priceIsDisplayed = false;
			System.out.println("Exception Sales price is not displayed on the page");
		}
		try {
			element(priceRegular).waitUntilVisible();
			scrollIntoView(priceRegular);
		} catch (Exception e) {
			priceRegularIsDisplayed = false;
			System.out.println("Exception Regular price is not displayed on the page");
		}
		Assert.assertTrue("Regular price and sales price are not displayed",
				priceIsDisplayed || priceRegularIsDisplayed);
		if(priceIsDisplayed) {
			return price.getText().trim();
		} else {
			return priceRegular.getText().trim();
		}
	}

	public void editProductQuantity(String qty) {
		element(quantityInput).waitUntilVisible();
		quantityInput.click();
		waitABit(2000);
		scrollIntoView(quantityInput);
		if(isMobile()) {
			quantityInput.sendKeys(Keys.BACK_SPACE);
			quantityInput.sendKeys(Keys.BACK_SPACE);
			quantityInput.sendKeys(Keys.BACK_SPACE);
			quantityInput.sendKeys(Keys.BACK_SPACE);

		} else{
			quantityInput.sendKeys(Keys.COMMAND + "a");
			quantityInput.sendKeys(Keys.DELETE);
			quantityInput.sendKeys(Keys.CONTROL + "a");
			quantityInput.sendKeys(Keys.DELETE);
		}
		waitABit(2000);
		quantityInput.sendKeys(qty);
		totalValue.click();
		waitABit(2000);

	}

	public void clickCheckout() {
		WebElement checkoutButton = getDriver().findElement(By.cssSelector(checkoutButtonCssSelector));
		scrollIntoView(checkoutButton);
		waitABit(2000);
		jsClick(checkoutButton);
		waitABit(5000);
	}

	public void clickViewCart() {
		element(viewCartButton).waitUntilVisible();
		scrollIntoView(viewCartButton);
		waitABit(2000);
		jsClick(viewCartButton);
		waitABit(5000);
	}
}
