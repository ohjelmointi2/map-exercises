package part03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PostalCodes {

    private static final Path postalCodesJSON = Path.of("data", "postcode_map_light.json");

    public static Map<String, String> readPostalCodes() {
        /*
         * See https://github.com/google/gson/blob/main/UserGuide.md#maps-examples
         */
        Gson gson = new Gson();
        TypeToken<Map<String, String>> mapType = new TypeToken<Map<String, String>>() {
        };

        try {
            String jsonString = Files.readString(postalCodesJSON, StandardCharsets.UTF_8);
            return gson.fromJson(jsonString, mapType);

        } catch (IOException e) {
            // If there's an exception reading the file, we can't continue.
            throw new RuntimeException(e);
        }
    }
}
