package map.basics;

import java.util.HashMap;
import java.util.Map;

public class Exercise1 {

    public Map<String, Long> buildPopulationMap() {
        var populations = new HashMap<String, Long>();

        populations.put("Denmark", 5_894_687L);
        populations.put("Finland", 5_587_442L);
        populations.put("Iceland", 354_234L);
        populations.put("Norway", 5_509_591L);
        populations.put("Sweden", 10_261_767L);

        return populations;
    }

    public void setPopulation(Map<String, Long> populations, String country, long population) {
        populations.put(country, population);
    }

    public void incrementPopulation(Map<String, Long> populations, String country, long change) {
        var previous = populations.getOrDefault(country, 0L);
        var next = previous + change;

        populations.put(country, next);
    }

    public long sumOfPopulations(Map<String, Long> map) {
        return map.values().stream().mapToLong(Long::valueOf).sum();
    }
}
