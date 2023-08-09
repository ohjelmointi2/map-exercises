package map.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

public class Exercise1Test {

    void testBuildingNewMap() {
        Exercise1 ex1 = new Exercise1();
        var populations = ex1.buildPopulationMap();

        assertNotNull(populations, "The build method must not return a null value");
        assertEquals(5, populations.size(), "The population map must have 5 entries");

        assertTrue(populations.containsKey("Finland"));
    }

    void testPopulationMapContents() {
        Exercise1 ex1 = new Exercise1();
        var populations = ex1.buildPopulationMap();

        Long fi = populations.get("Finland");
        assertEquals(5_587_442, fi, "Finland must have correct population");
    }

    void testSettingPopulation() {
        Exercise1 ex1 = new Exercise1();
        var map = new HashMap<String, Long>();

        // source: https://en.wikipedia.org/wiki/Demographics_of_Estonia
        long populationOfEstonia = 1_365_884L;
        ex1.setPopulation(map, "Estonia", populationOfEstonia);

        assertTrue(map.containsKey("Estonia"), "Map must have new key set");
        assertEquals(populationOfEstonia, map.get("Estonia"), "New population must be correct");
    }

    void testIncrementingPopulation() {

    }
}
