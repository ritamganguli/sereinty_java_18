package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	@FindBy(css = "#CustomerEmail")
	private WebElement email;

	@FindBy(css = "#CustomerPassword")
	private WebElement password;

	@FindBy(css = "div.login-form-wrap button.button--primary")
	private WebElement loginButton;

	public void verifyEmailFieldPresent() {
		element(email).waitUntilVisible();
		Assert.assertTrue("Email field is not present on the page.", email.isDisplayed());
	}

	public void login(String myEmail, String myPassword) {
		clickAccountIcon();
		element(email).waitUntilVisible();
		email.clear();
		email.sendKeys(myEmail);
		password.clear();
		password.sendKeys(myPassword);
		loginButton.click();
		waitABit(2000);
	}
}
