package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;


@RunWith(Suite.class)
@SuiteClasses({


        Test003_CheckoutLoggedInUser.class,
        Test004_AddToCartGreenButtonWithLoggedInUser.class,


})

public class TestSuite_LoggedInUsers {
}