package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.CustomConditions;

public class ProductPage extends AbstractPage {

    private String baseUrl;

    private static final By byAddOneToCartButton = By.xpath("//div[@class='c7x4 ui-k4']");
    private static final By byInstallmentLabel = By.xpath("//div[@class='b2n4']");

    @FindBy(xpath = "//h1[@class='b3a8']")
    private WebElement productName;

    @FindBy(xpath = "//a[contains(text(), 'Санкт-Петербург')]")
    private WebElement saintPetersburgCityLabel;

    @FindBy(xpath = "//div[@class='ui-k8 ui-l7 ui-m5 ui-n3']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='b1g8 ui-k4']")
    private WebElement addToFavoritesButton;

    @FindBy(xpath = "//div[@class='bq2']")
    private WebElement addToComparisonButton;

    @FindBy(xpath = "//div[@class='c7x4 ui-k4']")
    private WebElement addOneToCartButton;

    @FindBy(xpath = "//span[@class='c8q7 c8q8']")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='ui-k8 ui-m4']")
    private WebElement changeRegionSpan;

    @FindBy(xpath = "//span[@class='b0r3 b2z']/span")
    private WebElement currentCitySpan;

    public ProductPage(String pageUrl) {
        super();
        this.baseUrl = pageUrl;
    }

    public String getInstallmentLabel(){
        return driverWait.until(ExpectedConditions
                    .presenceOfElementLocated(byInstallmentLabel)).getText();
    }

    public ProductPage clickOnChangeRegionSpan() {
        logger.info("Clicking on 'change region' button");
        this.changeRegionSpan.click();
        return this;
    }

    public String getSaintPetersburgCityLabel(){
        return this.saintPetersburgCityLabel.getText();
    }

    public ProductPage clickOnSaintPetersburgCityLabel(){
        this.saintPetersburgCityLabel.click();
        return this;
    }

    public SearchResultsPage goBackToSearchResultPage(){
        logger.info("Navigating back to previous page");
        driver.navigate().back();
        return new SearchResultsPage();
    }

    public ProductPage() {
        super();
    }

    @Override
    public ProductPage openPage() {
        driver.navigate().to(baseUrl);
        logger.info("Page opened: " + baseUrl);
        return this;
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText().trim();
    }

    public ProductPage addProductToCart() {
        logger.info("Adding product to the cart");
        addToCartButton.click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(byAddOneToCartButton));
        return this;
    }

    public ProductPage addProductToFavorites() {
        logger.info("Adding product to favorites");
        addToFavoritesButton.click();
        return this;
    }

    public ProductPage addProductToComparison() {
        logger.info("Adding product to comparison");
        addToComparisonButton.click();
        return this;
    }

    public ProductPage addOneMoreToCart() {
        addOneToCartButton.click();
        CustomConditions.waitForJStoLoadWithThreadSleep(driver);
        return this;
    }

    public String getCurrentCitySpan() {
        CustomConditions.waitForJStoLoadWithThreadSleep(driver);
        return this.currentCitySpan.getText();
    }
}
