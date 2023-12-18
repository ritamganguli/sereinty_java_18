package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountPage extends BasePage {
    @FindBy(css = "h1.customer__title")
    private List<WebElement> customerTitles;

    @FindBy(css = "div[class *= 'my-account-annoucement my-account-annoucement-mobile']")
    private WebElement annoucement;

    @FindBy(xpath = "//h2[contains(., 'Bestellhistorie') or contains(.,'Order history')]")
    private WebElement orderHistory;

    @FindBy(css = "li.menu-link a[href $= '/account']")
    private WebElement trackAndManageOrders;
    @FindBy(css = "li.menu-link a[href $= '/pages/reward']")
    private WebElement loyaltyPoints;
    @FindBy(css = "li.menu-link a[href $= '/account/addresses']")
    private WebElement addressBook;
    @FindBy(css = "li.menu-link a[href $= '/pages/wishlist']")
    private WebElement wishlist;
    @FindBy(css = "li.menu-link a[href $= '/pages/profile']")
    private WebElement reviews;
    @FindBy(css = "li.menu-link a[data-src = '#language-modal")
    private WebElement language;
    @FindBy(css = "li.menu-link a[href $= '/account/logout']")
    private WebElement logoutLinkOnPage;


    @FindBy(css = "li.account-item a[href $= '/account']")
    private WebElement accountDrawerAccountDetails;
    @FindBy(css = "li.account-item a[href $= '/pages/reward']")
    private WebElement accountDrawerLoyaltyPoints;
    @FindBy(css = "li.account-item a[href $= '/account/addresses']")
    private WebElement accountDrawerAddressBook;
    @FindBy(css = "li.account-item a[href $= '/pages/wishlist']")
    private WebElement accountDrawerWishlist;
    @FindBy(css = "li.account-item a[href $= '/pages/profile']")
    private WebElement accountDrawerReviews;

    @FindBy(css = "li.account-item a[href $= '/account/logout']")
    private WebElement accountDrawerLogout;


    public void verifyAccountPageDetails() {
        element(logoutLinkOnPage).waitUntilVisible();
//        Assert.assertTrue("Announcement is not displayed", annoucement.isDisplayed());
        Assert.assertTrue("Customer name is not displayed", customerTitles.size() > 0);
        Assert.assertTrue("Order History is not displayed", orderHistory.isDisplayed());
        Assert.assertTrue("Track and Manage Orders is not displayed", trackAndManageOrders.isDisplayed());
        Assert.assertTrue("Loyalty Points is not displayed", loyaltyPoints.isDisplayed());
        Assert.assertTrue("Address Book is not displayed", addressBook.isDisplayed());
        Assert.assertTrue("Wishlist is not displayed", wishlist.isDisplayed());
        Assert.assertTrue("Reviews is not displayed", reviews.isDisplayed());
        Assert.assertTrue("Language is not displayed", language.isDisplayed());
        Assert.assertTrue("Log out is not displayed", logoutLinkOnPage.isDisplayed());
    }

    public void verifyAccountDrawerDetails() {
        element(accountDrawerAccountDetails).waitUntilVisible();
        Assert.assertTrue("Account Details is not displayed", accountDrawerAccountDetails.isDisplayed());
        Assert.assertTrue("Loyalty Points is not displayed", accountDrawerLoyaltyPoints.isDisplayed());
        Assert.assertTrue("Address Book is not displayed", accountDrawerAddressBook.isDisplayed());
        Assert.assertTrue("Wishlist is not displayed", accountDrawerWishlist.isDisplayed());
        Assert.assertTrue("Reviews is not displayed", accountDrawerReviews.isDisplayed());
        Assert.assertTrue("Log out is not displayed", accountDrawerLogout.isDisplayed());
    }

    public void verifyAccountDrawerLinks() {
        element(accountDrawerAccountDetails).waitUntilVisible();

        List<WebElement> accountDrawerMenuItems = new ArrayList<>(Arrays.asList(
                accountDrawerLoyaltyPoints, accountDrawerAddressBook,
                accountDrawerWishlist, accountDrawerReviews));

        String partialUrl = accountDrawerAccountDetails.getAttribute("href").replace("/en", "");
        accountDrawerAccountDetails.click();
        waitABit(3000);
        Assert.assertTrue("Expected url to end with: " + partialUrl +
                " but the url was: " + getDriver().getCurrentUrl(), getDriver().getCurrentUrl().endsWith(partialUrl));
        accountHeaderIcon.click();

        for(WebElement item : accountDrawerMenuItems) {
            element(item).waitUntilVisible();
            String itemPartialUrl = item.getAttribute("href").replace("/en","");
            item.click();
            waitABit(3000);
            String url = getDriver().getCurrentUrl();
            Assert.assertTrue("Expected url to end with: " + itemPartialUrl +
                    " but the url was: " + url, url.endsWith(itemPartialUrl));
            getDriver().navigate().back();
        }
    }


    public void logout() {
        element(accountDrawerLogout).waitUntilVisible();
        accountDrawerLogout.click();
    }

    public void logoutFromAccountDetailsPage() {
        element(logoutLinkOnPage).waitUntilVisible();
        logoutLinkOnPage.click();
    }

    public void verifyCustomerTitlePresent() {
        element(logoutLinkOnPage).waitUntilVisible();
        Assert.assertTrue("The customer title was not found. Login failed", customerTitles.size() > 0);
    }

    public void verifyCustomerTitleNotPresent() {
        waitABit(5000);
        Assert.assertTrue("The customer title exists. Logout failed", customerTitles.size() == 0);
    }

    public void verifyCustomerTitleContains(String text) {
        element(logoutLinkOnPage).waitUntilVisible();
        boolean found = false;
        for (WebElement title : customerTitles) {
            if (title.getText().contains(text)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue("The customer title did not contain: " + text, found);
    }
}
