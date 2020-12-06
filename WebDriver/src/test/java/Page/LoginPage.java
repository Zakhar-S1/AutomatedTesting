package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div/div[2]/div[3]")
    private WebElement loginAndPasswordFirstBtn;


    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement loginField;


    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[2]/div/form/div[4]")
    private WebElement loginAndPasswordSecondBtn;


    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div/div[2]/div[3]/div/div/div")
    private WebElement menuBtn;


    @FindBy(xpath = "//*[@id=\"main-content\"]/div[1]/div/div/div[2]/div[3]/div/div/div[3]/div/a[9]")
    private WebElement settingsBtn;


    public void inputEmail(String email) {
        loginField.sendKeys(email); }


    public void inputPassword(String password) {
        passwordField.sendKeys(password); }


    public void clickLoginAndPasswordFirstBtn() {
        loginAndPasswordFirstBtn.click(); }


    public void clickMenuBtn() {
        menuBtn.click(); }


    public void clickSettingsBtn() {
        settingsBtn.click(); }


    public void clickLoginAndPasswordSecondBtn() {
        loginAndPasswordSecondBtn.click(); }

}