package test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;
import page.MainPage;
import service.SearchPageDataReader;
import java.util.List;

public class TestSearchForProduct extends CommonConditions {

    @Test
    public void testSearchForProduct() {
        String searchQuery = SearchPageDataReader.getSearchQuery();

        List<String> expectedProductNames = new MainPage()
                .openPage()
                .sendQueryInSearchInput(searchQuery)
                .clickOnSearchSubmitButton()
                .getListOfProductNames();

        assertThat(expectedProductNames).allMatch(item -> item.contains(searchQuery));
    }

    @Test
    public void testSearchForProductWrong() {
        String correctSearchQuery = SearchPageDataReader.getSearchQuery();

        String wrongSearchQuery = SearchPageDataReader.getWrongKeyboardLayoutSearchQuery();

        List<String> actualProductNames = new MainPage()
                .openPage()
                .sendQueryInSearchInput(wrongSearchQuery)
                .clickOnSearchSubmitButton()
                .getListOfProductNames();

        assertThat(actualProductNames).allMatch(item -> item.contains(correctSearchQuery));
    }

    @Test
    public void testSearchListOfSuggestions(){
        String partOfSearchQuery = SearchPageDataReader.getPartSearchQuery();
        List<String> expectedProductNames = new MainPage()
                .openPage()
                .sendQueryInSearchInput(partOfSearchQuery)
                .getListOfSuggestions();

        assertThat(expectedProductNames).allMatch(item -> item
                .toLowerCase()
                .contains(partOfSearchQuery.toLowerCase()));
    }

}
