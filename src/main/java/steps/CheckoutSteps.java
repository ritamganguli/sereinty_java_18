package steps;

import pages.CheckoutPage;
import net.serenitybdd.annotations.Step;

public class CheckoutSteps extends BasePageSteps {
	private static final long serialVersionUID = 1L;
	
	CheckoutPage checkoutPage;
	
		
	@Step()
	public void verifyOnCheckoutPage() {
		checkoutPage.verifyOnCheckoutPage();
	}

	@Step()
	public void completeCheckout(String myEmail, String myCountry,
								 String myFirstName, String myLastName,
								 String myAddress, String myPostalCode, String myCity) {
		checkoutPage.completeCheckout(myEmail, myCountry, myFirstName, myLastName, myAddress, myPostalCode, myCity);
	}
}
