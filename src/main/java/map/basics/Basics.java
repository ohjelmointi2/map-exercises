package map.basics;

import java.util.Map;

public class Basics {

    public Map<String, Integer> getPopulations() {
        return null;
    }

    public Map<Integer, String> getWinners() {
        return null;
    }

    public long sumOfValues(Map<String, Long> map) {
        return map.values().stream().mapToLong(Long::longValue).sum();
    }

    public void removeNulls(Map<String, String> map) {

    }
}
