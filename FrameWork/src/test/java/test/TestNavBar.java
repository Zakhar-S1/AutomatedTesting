package test;

import org.testng.annotations.Test;
import page.MainPage;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class TestNavBar extends CommonConditions {

    @Test
    public void navBarTest(){
        MainPage mainPage = new MainPage();
        String navBarMenuItem = mainPage
                .openPage()
                .clickOnNavBarButton()
                .getSmartPhoneNavButtonSpan();

        List<String> expectedListOfProducts = mainPage
                .clickOnSmartPhoneNavButtonSpan()
                .getListOfProductNames();

        assertThat(expectedListOfProducts)
                .allMatch(item -> item.toLowerCase().contains(navBarMenuItem.toLowerCase().substring(0,navBarMenuItem.length() - 1)));
    }

}
