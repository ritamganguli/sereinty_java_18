package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import tests.*;


@RunWith(Suite.class)
@SuiteClasses({

        Test002_AddToCartGreenButtonWithoutLogin.class,
        Test004_AddToCartGreenButtonWithLoggedInUser.class,
        Test006_CheckoutFromCollectionGreenButton.class,
        Test007_CartPageDetails.class,
})

public class DebugTestSuite {
}