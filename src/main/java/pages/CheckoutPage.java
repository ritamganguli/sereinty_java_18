package pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#contact-collapsible")
    private WebElement emailAlreadyPresent;


    @FindBy(css = "select[name = 'countryCode']")
    private WebElement countrySelect;

    @FindBy(css = "input[name = 'firstName'][data-protected-input='true']")
    private WebElement firstName;
    @FindBy(css = "input[name = 'lastName'][data-protected-input='true']")
    private WebElement lastName;

    @FindBy(css = "input[id = 'TextField2']")
    private WebElement company;

    @FindBy(css = "input[name = 'address1'][data-protected-input = 'true']")
    private WebElement address;

    @FindBy(css = "input[name = 'postalCode'][required]")
    private WebElement postalCode;

    @FindBy(css = "input[name = 'city'][required]")
    private WebElement city;

    @FindBy(css = "input[id = 'TextField6']")
    private WebElement phone;

    @FindBy(css = "input[id = 'basic-creditCards']")
    private WebElement creditCardCheckbox;

    @FindBy(css = "input[id = 'basic-SOFORT']")
    private WebElement bankTransferCheckbox;

    @FindBy(css = "input#basic-paymentOnDelivery")
    private WebElement cashOnDeliveryCheckbox;

    @FindBy(css = "input#billing_address_selector-shipping_address")
    private WebElement sameAsShippingAddressCheckbox;

    @FindBy(css = "iframe[id *= 'card-fields-number']")
    private WebElement iframeCardNumber;
    @FindBy(css = "input[id = 'number']")
    private WebElement cardNumber;

    @FindBy(css = "iframe[id *= 'card-fields-expiry']")
    private WebElement iframeCardExpire;
    @FindBy(css = "input[id = 'expiry']")
    private WebElement cardExpireDate;

    private String reviewOrderXpathSelector = "//button[@type='submit'][contains(., 'Bestellung') or contains(.,'Review order')]";




    public void verifyOnCheckoutPage() {
        element(email).waitUntilVisible();
        Assert.assertTrue("Email field from the Checkout page was not found", email.isDisplayed());
        waitABit(3000);
    }

    public void completeCheckout(String myEmail, String myCountry,
                                 String myFirstName, String myLastName,
                                 String myAddress, String myPostalCode, String myCity) {
        element(countrySelect).waitUntilVisible();
        try {
            emailAlreadyPresent.isDisplayed();
        } catch (Exception e) {
            System.out.println("Exception on checkout page email auto completed was not present");
            email.clear();
            email.sendKeys(myEmail);
        }
        Select country = new Select(countrySelect);
        country.selectByValue(myCountry);
        waitABit(2000);

        firstName.clear();
        firstName.sendKeys(myFirstName);
        lastName.clear();
        lastName.sendKeys(myLastName);
//        company.clear();
//        company.sendKeys("myCompany");
        if(isMobile()) {
            address.sendKeys(Keys.COMMAND + "a");
            address.sendKeys(Keys.DELETE);
            jsSendKeys(address, "");
            jsSendKeys(address, myAddress);
//            address.sendKeys(myAddress);
//            address.sendKeys(Keys.ENTER);

        } else {
            address.clear();
            address.sendKeys(myAddress);
        }
        postalCode.clear();
        postalCode.sendKeys(myPostalCode);
        city.clear();
        city.sendKeys(myCity);
//        phone.clear();
//        phone.sendKeys("030 12345678");
//        creditCardCheckbox.click();
//        enterCreditCardDetails();
//        bankTransferCheckbox.click();
        cashOnDeliveryCheckbox.click();
        waitABit(2000);
        try {
            sameAsShippingAddressCheckbox.click();
            waitABit(2000);
        } catch (Exception e) {
            System.out.println("Exception in clicking the same as shipping address checkbox");
        }

        WebElement reviewOrder = getDriver().findElement(By.xpath(reviewOrderXpathSelector));
        jsClick(reviewOrder);
        waitABit(5000);
    }

}
