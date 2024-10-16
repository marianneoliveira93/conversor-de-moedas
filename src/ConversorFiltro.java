import com.google.gson.Gson;
import java.util.Map;

public class ConversorFiltro {
    public static void main(String[] args) {
        // Definindo o JSON como uma string
        String jsonResponse = "{\n" +
                "  \"base_code\": \"USD\",\n" +
                "  \"conversion_rates\": {\n" +
                "    \"ARS\": 350.25,\n" +
                "    \"BOB\": 6.87,\n" +
                "    \"BRL\": 5.35,\n" +
                "    \"CLP\": 880.00,\n" +
                "    \"COP\": 4050.00,\n" +
                "    \"USD\": 1.00\n" +
                "  }\n" +
                "}";

        // Inicializando Gson
        Gson gson = new Gson();

        // Convertendo a resposta
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(jsonResponse, ExchangeRateResponse.class);

        // Obtendo  taxas de conversão
        Map<String, Double> rates = exchangeRateResponse.getConversionRates();

        // Códigos utilizados para as moedas que queremos vão ser filtradas
        String[] currencyCodes = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        // Exibindo os valores filtrados
        for (String code : currencyCodes) {
            if (rates.containsKey(code)) {
                System.out.println("Currency: " + code + " - Rate: " + rates.get(code));
            }
        }
    }
}
