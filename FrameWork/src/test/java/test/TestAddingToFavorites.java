package test;

import org.testng.annotations.Test;
import page.FavoritesPage;
import page.ProductPage;
import service.ProductPageDataReader;
import util.Utils;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAddingToFavorites extends CommonConditions {

    @Test
    public void testItemCharacteristicsAfterAddingToFavorites() {
        ProductPage productPage = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addProductToFavorites();
        int expectedPrice = Utils
                .convertPriceStringToInt(productPage.getProductPrice());
        String expectedName = productPage.getProductName();

        FavoritesPage favoritesPage = new FavoritesPage()
                .openPage();

        String actualName = favoritesPage.getItemNameByIndex(0);
        int actualPrice = Utils
                .convertPriceStringToInt(favoritesPage.getItemPriceByIndex(0));

        assertThat(actualPrice).isEqualTo(expectedPrice);
        assertThat(actualName).isEqualTo(expectedName);
    }
}
