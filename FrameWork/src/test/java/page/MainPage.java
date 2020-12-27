package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.CustomConditions;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends AbstractPage
{

	private static final String BASE_URL = "https://www.ozon.ru/";

	private static final By byListOfSuggestions = By.xpath("//a[@class='b7h suggestions-item type-suggests']");
	private static final By byClosePopupButton = By.xpath("//div[@class='c6u ui-k4']");

	@FindBy(xpath="//input[@class='b7i5']")
	private WebElement searchInput;

	@FindBy(xpath = "//div[@class='ui-k8 ui-l5']")
	private WebElement navBarButton;

	@FindBy(xpath = "//button[@class='ui-k6 ui-n3']")
	private WebElement searchSubmitButton;

	@FindBy(xpath = "//span[contains(text(), 'Смартфоны')]")
	private WebElement smartPhoneNavButtonSpan;

	@FindBy(xpath = "//a[@class='b7h suggestions-item type-suggests']")
	private List<WebElement> listOfSuggestions;

	public MainPage()
	{
		super();
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Opened page " + BASE_URL);
		driverWait.until(ExpectedConditions.presenceOfElementLocated(byClosePopupButton)).click();
		return this;
	}

	public MainPage sendQueryInSearchInput(String searchQuery){
		this.searchInput.click();
		this.searchInput.sendKeys(searchQuery);
		logger.info("Entered query: " + searchQuery);
		return this;
	}

	public SearchResultsPage clickOnSearchSubmitButton() {
		logger.info("Submitting search query");
		this.searchSubmitButton.click();
		return new SearchResultsPage();
	}

	public MainPage clickOnNavBarButton() {
		logger.info("Opening navigation bar");
		this.navBarButton.click();
		return this;
	}

	public String getSmartPhoneNavButtonSpan() {
		CustomConditions.waitForJStoLoadWithThreadSleep(driver);
		return this.smartPhoneNavButtonSpan.getText();
	}

	public SearchResultsPage clickOnSmartPhoneNavButtonSpan(){
		this.smartPhoneNavButtonSpan.click();
		return new SearchResultsPage();
	}

	public List<String> getListOfSuggestions(){
		CustomConditions.waitForJStoLoadWithThreadSleep(driver);
		driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byListOfSuggestions));
		List<String> suggestionsNameList = new ArrayList<>();
		for(WebElement textElement : listOfSuggestions) {
			suggestionsNameList.add(textElement.getText());
		}
		return suggestionsNameList;
	}

}
