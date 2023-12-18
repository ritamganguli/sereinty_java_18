package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

	@Managed(uniqueSession = true)
	public WebDriver driver;

	@ManagedPages
	public Pages pages;

	EnvironmentVariables environmentVariables;
	
	public String getProperty(String propertyName) {
		return environmentVariables.optionalProperty(propertyName).get();
	}
} 