package pages;

import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String navigationCoffeeSelector, navigationCoffeeNewInShopSelector,
            typesOfCoffeeSelector, espressoSelector, filterSelector;

    public HomePage() {
        if (isMobile()) {

            // MOBILE ELEMENTS
            navigationCoffeeSelector = "#HeaderDrawer-kaffee";
            navigationCoffeeNewInShopSelector = "#HeaderDrawer-kaffee-neu-im-shop";
            typesOfCoffeeSelector = "#HeaderDrawer-kaffee-kaffeesorten";
            espressoSelector = "#HeaderDrawer-kaffee-kaffeesorten-espresso";
            filterSelector = "#HeaderDrawer-kaffee-kaffeesorten-filter";
        } else {

            // WEB ELEMENTS
            navigationCoffeeSelector = "#HeaderMenu-kaffee";
            navigationCoffeeNewInShopSelector = "#HeaderMenu-kaffee-neu-im-shop";
            typesOfCoffeeSelector = "#HeaderMenu-kaffee-kaffeesorten";
            espressoSelector = "#HeaderMenu-kaffee-kaffeesorten-espresso";
            filterSelector = "#HeaderMenu-kaffee-kaffeesorten-filter";
        }
    }

    public void clickCoffeeCollection() {
        if (isMobile()) {
            element(hamburgerIcon).waitUntilVisible();
            scrollIntoView(hamburgerIcon);
            hamburgerIcon.click();
            waitABit(2000);
        }
        WebElement navigationCoffee = getDriver().findElement(By.cssSelector(navigationCoffeeSelector));
        if (isMobile()) {
            navigationCoffee.click();
        } else {
            moveToElement(navigationCoffee);
        }
    }

    public void clickNewInShop() {
        WebElement navigationCoffeeNewInShop = getDriver().findElement(By.cssSelector(navigationCoffeeNewInShopSelector));
        navigationCoffeeNewInShop.click();
    }

    public void clickTypesOfCoffee() {
        WebElement navigationTypesOfCoffee = getDriver().findElement(By.cssSelector(typesOfCoffeeSelector));
        navigationTypesOfCoffee.click();
    }

    public void clickEspresso() {
        WebElement navigationEspresso = getDriver().findElement(By.cssSelector(espressoSelector));
        navigationEspresso.click();
    }

    public void clickFilter() {
        WebElement navigationFilter = getDriver().findElement(By.cssSelector(filterSelector));
        scrollIntoView(navigationFilter);
        navigationFilter.click();
    }
}
