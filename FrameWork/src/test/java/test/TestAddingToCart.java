package test;

import org.testng.annotations.Test;
import page.CartPage;
import page.ProductPage;
import service.ProductPageDataReader;
import util.Utils;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAddingToCart extends CommonConditions {

    @Test
    public void testAddingItemToCartSeveralTimes() {
        int expectedAmount = ProductPageDataReader.getItemAddAmount();
        ProductPage productPage = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addProductToCart();
        int expectedPrice =
                (expectedAmount) * Utils.convertPriceStringToInt(productPage.getProductPrice());
        for(int i = 0; i < expectedAmount - 1; i++) {
            productPage.addOneMoreToCart();
        }

        CartPage cartPage = new CartPage()
                .openPage();

        int actualPrice = Utils
                .convertPriceStringToInt(cartPage.getFinalPrice());

        int actualAmount = cartPage.getItemQuantityByIndex(0);

        assertThat(actualPrice).isEqualTo(expectedPrice);
        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

    @Test
    public void testItemCharacteristicsAfterAddingToCart() {
        ProductPage productPage = new ProductPage(ProductPageDataReader.getProductPageUrl())
                .openPage()
                .addProductToCart();
        int expectedPrice = Utils
                .convertPriceStringToInt(productPage.getProductPrice());
        String expectedName = productPage.getProductName();

        CartPage cartPage = new CartPage()
                .openPage();

        int actualPrice = Utils
                .convertPriceStringToInt(cartPage.getItemPriceByIndex(0));
        String actualName = cartPage.getItemNameByIndex(0);

        assertThat(actualPrice).isEqualTo(expectedPrice);
        assertThat(actualName).isEqualTo(expectedName);
    }
}
