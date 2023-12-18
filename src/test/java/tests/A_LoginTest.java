package tests;

import common.Application;
import common.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Story;
import net.serenitybdd.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "Test001_Login.csv", separator = ',')
public class A_LoginTest extends BaseTest {

    @Steps
    public LoginSteps loginSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public AccountSteps accountSteps;


    String user, password, expectedProfileName;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("A_LoginTest")
    public void loginTest() {
        loginSteps.navigateToBaseUrl();
        loginSteps.login(user, password);
        accountSteps.verifyCustomerTitlePresent();
        accountSteps.verifyCustomerTitleContains(expectedProfileName);
    }

    @After
    public void after() {
        try {
            homePageSteps.clickLogo();
            homePageSteps.clickAccountIcon();
            accountSteps.logout();
        } catch (Exception e) {
            System.out.println("Exception in after method");
        }
    }
} 