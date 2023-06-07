package map.names;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    public void testLastNameStats() {
        Map<String, Integer> names = Names.lastNameStats();

        assertEquals(21_144, names.get("Virtanen"));
    }

    @Test
    public void testFirstNameStats() {
        Map<String, Integer> names = Names.firstNameStats();

        assertEquals(280_306, names.get("Juhani"));
    }

}
