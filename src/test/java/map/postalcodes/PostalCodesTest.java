package map.postalcodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class PostalCodesTest {

    @Test
    void testReadPostalCodes() {
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();

        assertEquals("HELSINKI", postalCodes.get("00100"));
        assertEquals("KORVATUNTURI", postalCodes.get("99999"));
    }

    @Test
    void testGroupByName() {
        Map<String, String> postalCodes = PostalCodes.readPostalCodes();
        Map<String, List<String>> grouped = PostalCodes.groupByName(postalCodes);

        assertEquals(144, grouped.get("HELSINKI").size());
        assertEquals(1, grouped.get("PÖLJÄ").size());
    }
}
