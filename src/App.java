import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Supondo que você já tenha a lógica para obter os rates
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
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(jsonResponse, ExchangeRateResponse.class);
        Map<String, Double> rates = exchangeRateResponse.getConversionRates();

        // Criando o Scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Exibindo o menu
            System.out.println("=== Conversor de Moedas ===");
            System.out.println("1. Converter Moeda");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            // Lendo a escolha do usuário
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Capturando a entrada do usuário para conversão
                    System.out.print("Insira o valor a ser convertido: ");
                    double amount = scanner.nextDouble();

                    System.out.print("Insira a moeda de origem (ex: USD, BRL): ");
                    String fromCurrency = scanner.next().toUpperCase();

                    System.out.print("Insira a moeda de destino (ex: ARS, COP): ");
                    String toCurrency = scanner.next().toUpperCase();

                    // Realizando a conversão
                    try {
                        double convertedAmount = ConverdorDeMoeda.convertCurrency(amount, fromCurrency, toCurrency, rates);
                        System.out.printf("%.2f %s é equivalente a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Encerrando atendimento. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (choice != 2); // Continua até que o usuário escolha sair

        scanner.close();
    }
}
