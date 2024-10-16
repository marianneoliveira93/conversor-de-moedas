import java.util.Map;

public class ConverdorDeMoeda {


    // Método utilizado para converter um valor de uma moeda para outra
    public static double convertCurrency(double amount, String fromCurrency, String toCurrency, Map<String, Double> rates) {
        if (!rates.containsKey(fromCurrency) || !rates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moeda não suportada");
        }

        // Calculando o valor em relação a base
        double amountInBaseCurrency = amount / rates.get(fromCurrency);
        // Convertendo para a moeda desejada
        return amountInBaseCurrency * rates.get(toCurrency);
    }
}
