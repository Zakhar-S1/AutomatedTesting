package test;

import org.testng.annotations.Test;
import page.ProductPage;
import service.ProductPageDataReader;

import static org.assertj.core.api.Assertions.assertThat;

public class TestChangeCity extends CommonConditions {

    @Test
    public void cityChangeTest(){
        String productPageUrl = ProductPageDataReader.getProductPageUrl();
        ProductPage productPage = new ProductPage(productPageUrl);

        String changeToCityString = productPage
                .openPage()
                .clickOnChangeRegionSpan()
                .getSaintPetersburgCityLabel();

        String expectedCityString = productPage
                .clickOnSaintPetersburgCityLabel()
                .getCurrentCitySpan();

        assertThat(expectedCityString).contains(changeToCityString);

    }
}
