package Test;

import Page.AccountSettingsPage;
import Page.LoginPage;
import Properties.ConfProperties;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static WebDriver driver;
    public static AccountSettingsPage accountSettingsPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginPage"));
    }


    @Test
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginAndPasswordFirstBtn();
        loginPage.inputEmail(ConfProperties.getProperty("email"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginAndPasswordSecondBtn();
        loginPage.clickMenuBtn();
        loginPage.clickSettingsBtn();
        String username = accountSettingsPage.getUsername();
        Assert.assertEquals(ConfProperties.getProperty("username"), username);
    }

}