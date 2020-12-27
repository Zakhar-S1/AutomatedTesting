package util;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static int convertPriceStringToInt(String priceString) {
        return Integer
                .parseInt(priceString.replaceAll("[^0-9]", ""));
    }

    public static List<Integer> convertListOfPricesToListOfInts(List<String> pricesList) {
        List<Integer> integerPriceList = new ArrayList<>();
        for (String price :
        pricesList) {
            integerPriceList.add(Integer
                    .parseInt(price.replaceAll("[^0-9]", "")));
        }
        return integerPriceList;
    }

}
