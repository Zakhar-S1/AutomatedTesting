package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.CustomConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends AbstractPage {

    private static final By byMaxPriceInput = By.xpath("//div[@class='ui-c5']/div[2]/input");
    private static final By byProductNamesLocator = By.xpath("//a[@class='a2g0 tile-hover-target']");
    private static final By byInstallmentCheckBox = By.xpath("//div[@value='Доступно в рассрочку']/label/div[@class='ui-at4']");
    private static final By byFirstProductElement = By.xpath("//div[@class='ao4']/div[1]/div/div/div/div/a");
    private static final By bySecondProductElement = By.xpath("//div[@class='ao4']/div[2]/div/div/div/div/a");

    @FindBy (xpath = "//a[@class='a2g0 tile-hover-target']")
    private  List<WebElement> productsList;

    @FindBy(xpath = "//span[@class='b5v6 b5v7 c4v8']")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//div[@class='ui-c5']/div[2]/input")
    private WebElement maxPriceInput;

    public List<String> getListOfProductNames() {
        CustomConditions.waitForJStoLoadWithThreadSleep(driver);
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byProductNamesLocator));
        List<String> productNameList = new ArrayList<>();
        for(WebElement textElement : productsList) {
            productNameList.add(textElement.getText());
        }
        return productNameList;
    }


    public List<String> getProductPriceListOfProducts() {
        List<String> productPriceListString = new ArrayList<>();
        CustomConditions.waitForJStoLoadWithThreadSleep(driver);
        for(WebElement textElement : productPriceList) {
            productPriceListString.add(textElement.getText());
        }
        return productPriceListString;
    }


    public SearchResultsPage clickOnInstallmentCheckBox(){
        driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byInstallmentCheckBox)).click();
        return new SearchResultsPage();
    }

    public ProductPage clickOnFirstElementOnPage(){
        logger.info("Clicking the first element on page");
        CustomConditions.waitForJStoLoadWithThreadSleep(driver);
        driverWait.until(ExpectedConditions.elementToBeClickable(byFirstProductElement)).click();
        return new ProductPage();
    }

    public SearchResultsPage sendMaxPriceInput(String maxPrice){
        driverWait.until(ExpectedConditions
                .presenceOfElementLocated(byMaxPriceInput)).sendKeys(Keys.CONTROL +"a");
        this.maxPriceInput.sendKeys(Keys.DELETE);
        this.maxPriceInput.sendKeys(maxPrice);
        this.maxPriceInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage();
    }

    public ProductPage clickOnSecondElementOnPage(){
        logger.info("Clicking the second element on page");
        CustomConditions.waitForJStoLoadWithThreadSleep(driver);
        driverWait.until(ExpectedConditions.elementToBeClickable(bySecondProductElement)).click();
        return new ProductPage();
    }

    public SearchResultsPage() {
        super();
        logger.info("Opened search results page " + driver.getCurrentUrl());
    }

    @Override
    protected SearchResultsPage openPage() {
        logger.error("Cannot open SearchResultsPage by itself! Throwing exception");
        throw new RuntimeException("Cannot open SearchResultsPage by itself!");
    }

}
