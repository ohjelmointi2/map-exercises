package part03;

import java.util.Map;

public class PostalCodesMain {

    public static void main(String[] args) {
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        System.out.println("Postal code 00100 is for " + postalCodes.get("00100"));
        System.out.println("Postal code 99999 is for " + postalCodes.get("99999"));
    }
}
