package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;


@RunWith(Suite.class)
@SuiteClasses({


        Test001_CheckoutWithoutLogin.class,
        Test002_AddToCartGreenButtonWithoutLogin.class,



})

public class TestSuite_NotLoggedIn {
}