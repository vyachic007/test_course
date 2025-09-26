package by.slava_borisov.currency;

import java.util.Map;
import java.util.Set;

public class CurrencyDisplay {

    public void showWelcomeMessage() {
        System.out.println("Добро пожаловать в конвертор валют\n");
    }

    public void showAvailableCurrencies(Set<String> currencies) {
        System.out.println("Доступные валюты:");
        for (String c : currencies) {
            System.out.println("- " + c);
        }
    }

    public void showConversionResults(
            double amount,
            String fromCurrency,
            Map<String, Double> results
    ) {
        System.out.println("Результаты конвертации: " + amount + " " + fromCurrency);
       results.forEach((c, r) -> System.out.println(c + ": " + r));
    }


}
