package map.names;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Names {

    private static final String lastNameFile = "sukunimitilasto.csv";

    private static final List<Path> firstNameFiles = List.of(
            Path.of("data", "etunimitilasto-miehet-ensimmainen.csv"),
            Path.of("data", "etunimitilasto-naiset-ensimmainen.csv"),
            Path.of("data", "etunimitilasto-miehet-muut.csv"),
            Path.of("data", "etunimitilasto-naiset-muut.csv"));

    public static void main(String[] args) {
        Map<String, Integer> firstNames = firstNameStats();

        firstNames.forEach((String name, Integer count) -> {
            System.out.println(name + " " + count);
        });
    }

    public static Map<String, Integer> lastNameStats() {
        return readStatsFromFile(Path.of("data", lastNameFile));
    }

    public static Map<String, Integer> firstNameStats() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (Path filePath : firstNameFiles) {
            Map<String, Integer> stats = readStatsFromFile(filePath);

            stats.forEach((name, count) -> {
                hashMap.merge(name, count, (previous, add) -> previous + add);
            });
        }

        return hashMap;

    }

    private static Map<String, Integer> readStatsFromFile(Path csvPath) {
        HashMap<String, Integer> stats = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(csvPath, StandardCharsets.UTF_8);
            lines
                    .stream()
                    .skip(1)
                    .forEach((String rivi) -> {
                        String[] parts = rivi.split(";");
                        var name = parts[0];
                        var count = Integer.parseInt(parts[1].replaceAll(" ", ""));

                        stats.put(name, count);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stats;
    }
}
