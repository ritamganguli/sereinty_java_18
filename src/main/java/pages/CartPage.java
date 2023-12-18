package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

	private String priceCssSelector;

	public CartPage() {
		if (isMobile()) {

			// MOBILE ELEMENTS
			priceCssSelector = "tr.cart-item td[class *= 'large-up-hide'] span.price.price--end";

		} else {

			// WEB ELEMENTS
			priceCssSelector = "tr.cart-item td[class *= 'small-hide'] span.price.price--end";
		}
	}



	@FindBy(css = "button#checkout")
	private WebElement checkoutButton;

	@FindBy(css = "div.cart__items button[class *= 'quantity__button'][name='plus']")
	private WebElement quantityButtonPlus;

	@FindBy(css = "div.cart__items button[class *= 'quantity__button'][name='minus']")
	private WebElement quantityButtonMinus;

	@FindBy(css = "div.cart__items input[class='quantity__input']")
	private WebElement quantityInput;

	@FindBy(css = "div.cart__footer div[class = 'totals'] > p.totals__subtotal-value")
	private WebElement totalValue;

	private String productNameCssSelector = "div#main-cart-items td.cart-item__details > a";



	public String getProductName() {
		waitABit(3000);
		element(By.cssSelector(productNameCssSelector)).waitUntilVisible();
		return element(By.cssSelector(productNameCssSelector)).getText().trim();
	}
	public String getPrice() {
		WebElement price = getDriver().findElement(net.serenitybdd.core.annotations.findby.By.cssSelector(priceCssSelector));
		return price.getText().trim();
	}

	public String getProductQuantity() {
		element(quantityInput).waitUntilVisible();
		return quantityInput.getAttribute("data-cart-quantity");
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

	public String getTotalValue() {
		element(totalValue).waitUntilVisible();
		String text = totalValue.getText();
		text = text.replace("€", "").replace("EUR", "").trim();
		return text;
	}

	public void clickCheckout() {
		element(checkoutButton).waitUntilVisible();
		scrollIntoView(checkoutButton);
		jsClick(checkoutButton);
		waitABit(5000);
	}
}
