import com.google.gson.Gson;

import java.util.Map;

public class ExchangeRateResponse {
    // Definindo os campos que correspondem ao JSON
    private String base_code;  // Nome do campo igual ao JSON
    private Map<String, Double> conversion_rates;  // Um mapa com as taxas de conversão

    // Getter - moeda base
    public String getBaseCode() {
        return base_code;
    }

    // Getter -  taxas de conversão
    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    //  setters caso queira modificar os valores
    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}

