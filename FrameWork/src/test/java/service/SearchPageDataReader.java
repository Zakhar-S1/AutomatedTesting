package service;

public class SearchPageDataReader {

    public static final String TESTDATA_WRONG_SEARCH_QUERY = "testdata.wrong.searchQuery";
    public static final String TESTDATA_SEARCH_QUERY = "testdata.searchQuery";
    public static final String TESTDATA_PART_SEARCH_QUERY = "testdata.part.searchQuery";
    public static final String TESTDATA_INSTALLMENT_STRING = "testdata.installment.string";
    public static final String TESTDATA_MAXPRICE = "testdata.maxprice";

    public static String getSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_SEARCH_QUERY);
    }

    public static String getPartSearchQuery(){
        return TestDataReader.getTestData(TESTDATA_PART_SEARCH_QUERY);
    }

    public static String getWrongKeyboardLayoutSearchQuery() {
        return TestDataReader.getTestData(TESTDATA_WRONG_SEARCH_QUERY);
    }

    public static String getInstallmentQuery() {
        return TestDataReader.getTestData(TESTDATA_INSTALLMENT_STRING);
    }

    public static String getMaxPrice() {
        return TestDataReader.getTestData(TESTDATA_MAXPRICE);
    }
}