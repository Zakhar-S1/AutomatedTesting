package page;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected static final Logger logger = LogManager.getRootLogger();
	protected static final int WAIT_TIMEOUT_SECONDS = 7;
	protected final WebDriverWait driverWait;
	protected WebDriver driver;

	protected abstract AbstractPage openPage();

	protected AbstractPage()
	{
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(this.driver, this);
		driverWait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
	}

}
