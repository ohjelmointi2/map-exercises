package map.postinumerot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PostalCodes {

    private static final Path postalCodesJSON = Path.of("data", "postcode_map_light.json");

    public static void main(String[] args) {
        Map<String, String> postalCodes = readPostalCodes();

        System.out.println(groupByName(postalCodes));
    }

    public static Map<String, List<String>> groupByName(Map<String, String> postalcodes) {
        Map<String, List<String>> grouped = new HashMap<>();

        postalcodes.forEach((code, name) -> {
            if (!grouped.containsKey(name)) {
                grouped.put(name, new ArrayList<>());
            }
            grouped.get(name).add(code);
        });
        return grouped;
    }

    public static Map<String, String> readPostalCodes() {
        TypeToken<Map<String, String>> mapType = new TypeToken<Map<String, String>>() {
        };
        Gson gson = new Gson();

        try {
            String jsonString = Files.readString(postalCodesJSON, StandardCharsets.UTF_8);
            return gson.fromJson(jsonString, mapType);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
