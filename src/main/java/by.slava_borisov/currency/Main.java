package by.slava_borisov.currency;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExchangeRates exchangeRates = new ExchangeRates();
        exchangeRates.initializeDefaultRates();

        CurrencyConverter converter = new CurrencyConverter(exchangeRates);
        CurrencyDisplay display = new CurrencyDisplay();

        display.showWelcomeMessage();
        display.showAvailableCurrencies(exchangeRates.getAvailableCurrencies());

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        ;

        while (true) {
            double amount = 0;
            System.out.print("Введите сумму конвертации: ");
            String amountStr = scanner.next();
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
                continue;
            }

            System.out.println("Введите исходную валюту:");
            String fromCurrency = scanner.next().toUpperCase();
            if (!exchangeRates.getAvailableCurrencies().contains(fromCurrency)) {
                System.out.printf("Валюта %s не найдена\n", fromCurrency);
                continue;
            }

            Map<String, Double> results = converter.convertToAll(amount, fromCurrency);
            display.showConversionResults(amount, fromCurrency, results);

            System.out.println("Выполнить еще конвертацию? (да/нет):");
            String answer = scanner.next().toLowerCase();
            if (answer.equalsIgnoreCase("нет")) {
                break;
            }
        }
        scanner.close();
    }

    // TODO проверку на ввод данных
}
