package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.*;


@RunWith(Suite.class)
@SuiteClasses({

        A_LoginTest.class,
        A_LogoutTest.class,
        Test001_CheckoutWithoutLogin.class,
        Test002_AddToCartGreenButtonWithoutLogin.class,
        Test003_CheckoutLoggedInUser.class,
        Test004_AddToCartGreenButtonWithLoggedInUser.class,
        Test005_CheckoutFromCollections.class,
        Test006_CheckoutFromCollectionGreenButton.class,
        Test007_CartPageDetails.class,
        Test008_CheckoutFromPDP.class,
        Test009_CheckoutFromPDPViewCart.class,
        Test010_ExistingAccountMenu.class,
        Test011_AccountDrawerLinks.class,


})

public class TestSuite {
}