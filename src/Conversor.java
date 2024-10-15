import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class Conversor {
    public static void main(String[] args) throws Exception {
        String apiKey = "c297e3518a0a4b9c0e89d1fe";
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Criando a solicitação HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .GET()
                .build();

        // Enviando a solicitação e obtendo a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimindo o corpo da resposta (JSON bruto)
        String jsonResponse = response.body();
        System.out.println(jsonResponse);

        // Passo 4: Parse do JSON com Gson
        Gson gson = new Gson();
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(jsonResponse, ExchangeRateResponse.class);

        // Acessando os dados da resposta
        System.out.println("Base Code: " + exchangeRateResponse.getBaseCode());
        System.out.println("Taxa de câmbio USD para EUR: " + exchangeRateResponse.getConversionRates().get("EUR"));
    }



}
