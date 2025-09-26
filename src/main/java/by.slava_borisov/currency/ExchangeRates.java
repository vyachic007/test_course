package by.slava_borisov.currency;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ExchangeRates {
    private Map<String, Double> rates = new HashMap<>();
    private String baseCurrency;

    public void addRate(
            String currency,
            double rate
    ) {
        rates.put(currency, rate);
    }

    public Double getRate(String currency) {
        return rates.get(currency);
    }


    public Set<String> getAvailableCurrencies() {
        return rates.keySet();
    }

    public void initializeDefaultRates() {
        rates.put("RUB", 1.0);
        rates.put("USD", 83.61);
        rates.put("EUR", 97.68);
        rates.put("KZT", 0.15);
        rates.put("CNY", 11.68);
    }
}



