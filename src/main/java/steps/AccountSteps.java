package steps;

import net.serenitybdd.annotations.Step;
import pages.AccountPage;

public class AccountSteps extends BasePageSteps {
    private static final long serialVersionUID = 1L;

    AccountPage accountPage;

    @Step()
    public void logout() {
        accountPage.logout();
    }

    @Step()
    public void logoutFromAccountDetailsPage() {
        accountPage.logoutFromAccountDetailsPage();
    }

    @Step()
    public void verifyCustomerTitlePresent() {
        accountPage.verifyCustomerTitlePresent();
    }

    @Step()
    public void verifyCustomerTitleNotPresent() {
        accountPage.verifyCustomerTitleNotPresent();
    }

    @Step()
    public void verifyCustomerTitleContains(String text) {
        accountPage.verifyCustomerTitleContains(text);
    }

    @Step()
    public void verifyAccountPageDetails() {
        accountPage.verifyAccountPageDetails();
    }

    @Step()
    public void verifyAccountDrawerDetails() {
        accountPage.verifyAccountDrawerDetails();
    }

    @Step()
    public void verifyAccountDrawerLinks() {
        accountPage.verifyAccountDrawerLinks();
    }
}