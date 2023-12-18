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
import steps.AccountSteps;
import steps.HomePageSteps;
import steps.LoginSteps;


@Story(Application.Login.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.BASE_DIR + "Test001_Login.csv", separator = ',')
public class Test011_AccountDrawerLinks extends BaseTest {

    @Steps
    public LoginSteps loginSteps;
    @Steps
    public HomePageSteps homePageSteps;
    @Steps
    public AccountSteps accountSteps;


    String user, password, expectedProfileName;


    @Test
//	@WithTags({@WithTag("smoke"), @WithTag("regression")})
    @Title("Test011 - Account Drawer Links")
    public void test011_AccountDrawerLinks() {
        loginSteps.navigateToBaseUrl();
        loginSteps.login(user, password);
        homePageSteps.clickAccountIcon();
        accountSteps.verifyAccountDrawerLinks();
    }

    @After
    public void after() {
        try {
            accountSteps.logout();
        } catch (Exception e) {
            System.out.println("Exception in after method");
        }
    }
} 