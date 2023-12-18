package steps;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.BasePage;

public class BasePageSteps extends ScenarioSteps {
    private static final long serialVersionUID = 1L;

    BasePage basePage;

    @Step("Click Logo")
    public void clickLogo() {
        basePage.clickLogo();
    }

    @Step("Click Logo")
    public void clickLogoOnCheckoutPage() {
        basePage.clickLogoOnCheckoutPage();
    }

    @Step()
    public void clickAccountIcon() {
        basePage.clickAccountIcon();
    }

    @Step("Check if is Mobile version")
    public boolean isMobile() {
        return basePage.isMobile();
    }

    @Step("Navigate to Base URL")
    public void navigateToBaseUrl() {
        basePage.navigateToBaseUrl();
    }

    @Step("Navigate URL {0}")
    public void navigateURL(String url) {
        basePage.navigateURL(url);
    }
}
