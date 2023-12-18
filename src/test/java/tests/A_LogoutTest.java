package tests;

import common.Application;
import common.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Story;
import net.serenitybdd.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.AccountSteps;
import steps.HomePageSteps;
import steps.LoginSteps;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "Test001_Login.csv", separator = ',')
public class A_LogoutTest extends BaseTest {

    @Steps
    public LoginSteps loginSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public AccountSteps accountSteps;


    String user, password, expectedProfileName;

    @Before
    public void before() {
        loginSteps.navigateToBaseUrl();
        loginSteps.login(user, password);
    }

    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("A_01_LogoutTest")
    public void logoutTest() {
        homePageSteps.clickAccountIcon();
        accountSteps.logout();
        homePageSteps.clickAccountIcon();
        loginSteps.verifyEmailFieldPresent();
        accountSteps.verifyCustomerTitleNotPresent();
    }

    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("A_02_LogoutTest")
    public void logoutTest2() {
        accountSteps.logoutFromAccountDetailsPage();
        homePageSteps.clickAccountIcon();
        loginSteps.verifyEmailFieldPresent();
        accountSteps.verifyCustomerTitleNotPresent();
    }
} 