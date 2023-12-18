package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class A_LambdaTest extends BaseTest {
    @Test
    public void loginTest() {
        driver.get("https://google.com");
    }
} 