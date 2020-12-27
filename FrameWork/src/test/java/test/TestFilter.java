package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.ProductPage;
import service.SearchPageDataReader;
import util.Utils;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TestFilter extends CommonConditions {

    @Test
    public void installmentPlanTest(){
        String searchQuery = SearchPageDataReader.getSearchQuery();
        String installmentString = SearchPageDataReader.getInstallmentQuery();
        MainPage mainPage = new MainPage();

        ProductPage productPage = mainPage
                .openPage()
                .sendQueryInSearchInput(searchQuery)
                .clickOnSearchSubmitButton()
                .clickOnInstallmentCheckBox()
                .clickOnFirstElementOnPage();

        String expectedFirstInstallmentLabel = productPage
                .getInstallmentLabel();

        String expectedSecondInstallmentLabel = productPage
                .goBackToSearchResultPage()
                .clickOnSecondElementOnPage()
                .getInstallmentLabel();

        assertThat(expectedFirstInstallmentLabel.toLowerCase()).contains(installmentString);
        assertThat(expectedSecondInstallmentLabel.toLowerCase()).contains(installmentString);
    }

    @Test
    public void maxPriceTest() {
        String searchQuery = SearchPageDataReader.getSearchQuery();
        String maxPrice = SearchPageDataReader.getMaxPrice();

        List<String> expectedPrices = new MainPage()
                .openPage()
                .sendQueryInSearchInput(searchQuery)
                .clickOnSearchSubmitButton()
                .sendMaxPriceInput(maxPrice)
                .getProductPriceListOfProducts();

        assertThat(Utils.convertListOfPricesToListOfInts(expectedPrices))
                .allMatch(item -> item <= Integer.parseInt(maxPrice));
    }


}
