package pages;

import common.Constants;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.model.util.EnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage extends PageObject {

    @FindBy(css = "header div h1 span > a")
    public WebElement logoOnCheckoutPage;

    @FindBy(css = "a[href ='/'][class *='header__heading-link']")
    public WebElement logo;

    @FindBy(css = "div[class *='header__icons'] a[class *= 'account']")
    public WebElement accountHeaderIcon;

    @FindBy(css = "svg[class *= 'icon-hamburger']")
    public WebElement hamburgerIcon;

    @FindBy(css = "svg[class *= 'icon-cart']")
    public WebElement cartIcon;

    @FindBy(css = "div.cart-count-bubble")
    public WebElement cartIconItemsInCart;

    private String cartRemoveButtonCssSelector = "button[class *= 'cart-remove-button']";
    private String closeCartPopupCssSelector = "button.drawer__close";

    EnvironmentVariables environmentVariables;

    public String getProperty(String propertyName) {
        return environmentVariables.optionalProperty(propertyName).get();
    }




    public void clickAccountIcon() {
        element(accountHeaderIcon).waitUntilVisible();
        waitABit(2000);
        accountHeaderIcon.click();
    }
    public void clickLogo() {
        element(logo).waitUntilVisible();
        logo.click();
    }

    public void clickLogoOnCheckoutPage() {
        element(logoOnCheckoutPage).waitUntilVisible();
        logoOnCheckoutPage.click();
    }

    public boolean isMobile() {
        String myDriver = ((WebDriverFacade) getDriver()).getProxiedDriver().toString().toLowerCase();
        if (myDriver.contains("iosdriver") ||
                myDriver.contains("uiauto") ||
                myDriver.contains("appium") ||
                myDriver.contains("ios") ||
                myDriver.contains("android")) {
            return true;
        } else return false;
    }

    public void navigateURL(String url) {
        getDriver().manage().window().maximize();
        waitABit(2000);
        getDriver().get(url);
    }

    public List<String> getIFrames() {
        List<String> list = new ArrayList<String>();
        List<WebElement> iframes = getDriver().findElements(org.openqa.selenium.By.xpath("//iframe"));
        for (WebElement iframe : iframes) {
            System.out.println("iFrame id: " + iframe.getAttribute("id"));
            list.add(iframe.getAttribute("id"));
        }
        return list;
    }

    public void clearCart() {
        element(cartIcon).waitUntilVisible();
        try {
            if(cartIconItemsInCart.isDisplayed()) {
                cartIcon.click();
                waitABit(3000);
                waitForListToLoad(getDriver().findElements(By.cssSelector(cartRemoveButtonCssSelector)), 10);
                while(getDriver().findElements(By.cssSelector(cartRemoveButtonCssSelector)).size() > 0) {
                    getDriver().findElements(By.cssSelector(cartRemoveButtonCssSelector)).get(0).click();
                    waitABit(2000);
                }
                getDriver().findElement(By.cssSelector(closeCartPopupCssSelector)).click();
                waitABit(1000);
            }
        } catch(Exception e) {
            System.out.println("Exception in clear cart");
        }
    }

    public void navigateToBaseUrl() {
        getDriver().get(getProperty(Constants.PROPERTY_BASE_URL));
//        getDriver().get(Constants.BASE_URL);

        if (!isMobile()) {
            getDriver().manage().window().maximize();
            waitABit(2000);
        }

        if (getDriver().getCurrentUrl().contains("staging")) {
            try {
                waitABit(2000);
                if (getDriver().findElement(By.cssSelector("div[class *= 'password-link']")).isDisplayed()) {
                    getDriver().findElement(By.cssSelector("div[class *= 'password-link']")).click();
                    getDriver().findElement(By.cssSelector("#Password")).sendKeys("eseint");
                    getDriver().findElement(By.cssSelector("button[class *= 'password-button']")).click();
                    waitABit(2000);
                }
            } catch (Exception e) {
                System.out.println("Exception in staging env enter password");
            }
        }

        try {
            waitABit(3000);
            WebElement el = getDriver().findElement(By.cssSelector("button[id *= 'AllowAll']"));
            jsClick(el);
        } catch (Exception e) {
            System.out.println("Exception in allow all popup");
        }

        try {
            waitABit(3000);
            List<WebElement> elements = getDriver().findElements(By.cssSelector("button[class *= 'needsclick'] > svg"));
            for (WebElement element : elements) {
                element.click();
                waitABit(2000);
            }
        } catch (Exception e) {
            System.out.println("Exception in closing other popups");
        }

    }


    public void jsClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", webElement);
        waitABit(2000);
    }

    public void jsSendKeys(WebElement webElement, String value) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + value + "';", webElement);
        waitABit(2000);
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", element);
        waitABit(2000);
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(element).perform();
        waitABit(2000);
    }

    public void waitForListToLoad(List<WebElement> list, long timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }
}
