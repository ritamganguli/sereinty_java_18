package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class A_FailTest extends BaseTest {
    @Test
    public void failTest() {

        driver.get("https://google.com");
        Assert.assertTrue("Failed intentionally", false);
    }
} 