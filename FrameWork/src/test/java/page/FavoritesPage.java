package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritesPage extends AbstractPage {
    private static final String BASE_URL = "https://www.ozon.ru/my/favorites";

    private static final By byItemName = By.xpath("//a[@class='a2g0 tile-hover-target']");
    private static final By byItemPrice = By.xpath("//span[@class='b5v6 b5v7 c4v8']");

    @FindBy(xpath = "//div[@class='a0c4']")
    private List<WebElement> favoriteElements;

    public FavoritesPage()
    {
        super();
    }

    @Override
    public FavoritesPage openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("Page opened: " + BASE_URL);
        return this;
    }

    public String getItemPriceByIndex(int index) {
        return favoriteElements.get(index).findElement(byItemPrice).getText();
    }

    public String getItemNameByIndex(int index) {
        return favoriteElements.get(index).findElement(byItemName).getText();
    }
}
