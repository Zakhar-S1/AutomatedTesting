package service;

public class ProductPageDataReader {

    public static final String TEST_DATA_ITEM_PAGE_URL = "testdata.itemPage.url";
    public static final String TEST_DATA_ITEM_ADD_AMOUNT = "testdata.item.addAmount";

    public static String getProductPageUrl() {
        return TestDataReader.getTestData(TEST_DATA_ITEM_PAGE_URL);
    }
    public static int getItemAddAmount() {
        return Integer.parseInt(TestDataReader.getTestData(TEST_DATA_ITEM_ADD_AMOUNT));
    }

}
