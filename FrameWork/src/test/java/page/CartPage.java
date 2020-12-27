package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {
    private static final String BASE_URL = "https://www.ozon.ru/cart";

    private static final By byItemPrice = By.xpath("//div[@class='a7o7']");
    private static final By byItemName = By.xpath("//a[@class='a7n3']/span");
    private static final By byItemQuantity = By.xpath("//div[@class='ui-a1k8']");

    @FindBy(xpath = "//div[@class='a7m4']")
    private List<WebElement> cartElements;

    @FindBy(xpath = "//div[@class='a5a6']/span[2]")
    private WebElement finalPrice;

    public CartPage()
    {
        super();
    }

    @Override
    public CartPage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Page opened: " + BASE_URL);
        return this;
    }

    public String getItemPriceByIndex(int index) {
        return cartElements.get(index).findElement(byItemPrice).getText().trim();
    }

    public String getItemNameByIndex(int index) {
        return cartElements.get(index).findElement(byItemName).getText();
    }

    public int getItemQuantityByIndex(int index) {
        return Integer.parseInt(cartElements.get(index).findElement(byItemQuantity).getText());
    }

    public String getFinalPrice() {
        return finalPrice.getText();
    }
}
