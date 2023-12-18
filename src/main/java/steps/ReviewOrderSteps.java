package steps;

import net.serenitybdd.annotations.Step;
import pages.ReviewOrderPage;

public class ReviewOrderSteps extends BasePageSteps {
	private static final long serialVersionUID = 1L;
	
	ReviewOrderPage reviewOrderPage;
	
		
	@Step()
	public void verifyPrice(String priceExpected) {
		reviewOrderPage.verifyPrice(priceExpected);
	}

	@Step()
	public void verifyProduct(String productName) {
		reviewOrderPage.verifyProduct(productName);
	}



	
}
