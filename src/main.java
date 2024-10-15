package Main;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("file.encoding", "UTF-8");
        Object UIOp = null;
    }
}

class JsonParserEx {
    public static void main(String[] args) {
        // Exemplo de uma resposta JSON
        String jsonResponse = "{ \"base_code\": \"USD\", \"conversion_rates\": { \"EUR\": 0.85, \"GBP\": 0.75, \"JPY\": 110.0 } }";

        // Parseando o JSON com Gson
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Extraindo informações do JSON
        String baseCode = jsonObject.get("base_code").getAsString();
        JsonObject conversionRates = jsonObject.get("conversion_rates").getAsJsonObject();
        double eurRate = conversionRates.get("EUR").getAsDouble();

        // Exibindo os dados extraídos
        System.out.println("Base Code: " + baseCode);
        System.out.println("Taxa USD para EUR: " + eurRate);
    }
}