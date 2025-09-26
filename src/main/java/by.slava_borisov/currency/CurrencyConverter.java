package by.slava_borisov.currency;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class CurrencyConverter {
    private ExchangeRates exchangeRates;

    public Double convert(
            Double amount,
            String fromCurrency,
            String toCurrency
    ) {
        Double fromRate = exchangeRates.getRate(fromCurrency);
        Double toRate = exchangeRates.getRate(toCurrency);
        if (fromRate == null || toRate == null) {
            return null;
        }

        return amount * (toRate / fromRate);
    }

    public Map<String, Double> convertToAll(
            double amount,
            String fromCurrency
    ) {
       Map<String, Double> results = new HashMap<>();
        Set<String> allCurrencies = exchangeRates.getAvailableCurrencies();

        for (String currency : allCurrencies) {
            if (!currency.equals(fromCurrency)) {
                results.put(currency, convert(amount, fromCurrency, currency));
            }
        }

        return results;
    }

}
