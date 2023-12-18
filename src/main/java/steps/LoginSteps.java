package steps;

import net.serenitybdd.annotations.Step;
import pages.LoginPage;

public class LoginSteps extends BasePageSteps {
    private static final long serialVersionUID = 1L;

    LoginPage loginPage;

    @Step()
    public void verifyEmailFieldPresent() {
        loginPage.verifyEmailFieldPresent();
    }

    @Step("Login with username {0} and password *********")
    public void login(String myEmail, String myPassword) {
        loginPage.login(myEmail, myPassword);
    }
}
