package part03;

import java.util.Map;
import java.util.Scanner;

public class PostalCodesMain {

    /**
     * Implement your logic in this method. You can also add your own methods and
     * classes if needed.
     */
    public static void main(String[] args) {
        // a Map from postal code ("00100") to postal district name ("HELSINKI").
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Mitä etsitään (esim. 00100 tai Helsinki)? ");
        String answer = scanner.nextLine();

        // TODO: Implement your logic here.

        scanner.close();
    }
}
