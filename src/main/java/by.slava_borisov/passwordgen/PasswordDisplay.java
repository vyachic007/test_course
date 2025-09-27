package by.slava_borisov.passwordgen;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class PasswordDisplay {
    private Scanner scanner;

    public void showWelcomeMessage() {
        System.out.println("Добро пожаловать в генератор паролей!");
    }

    public PasswordConfig getPasswordConfig() {
        int length;
        while (true) {
            System.out.print("Введите длину пароля (8-12): ");
            length = scanner.nextInt();

            if (length >= 8 && length <= 12) {
                break;
            } else {
                System.out.println("Ошибка: длина должна быть от 8 до 12!");
            }
        }

        System.out.print("Использовать заглавные буквы? (да/нет): ");
        boolean useUppercase = scanner.next().equalsIgnoreCase("да");

        System.out.print("Использовать строчные буквы? (да/нет): ");
        boolean useLowercase = scanner.next().equalsIgnoreCase("да");

        System.out.print("Использовать цифры? (да/нет): ");
        boolean useDigits = scanner.next().equalsIgnoreCase("да");

        System.out.print("Использовать спецсимволы? (да/нет): ");
        boolean useSpecialChars = scanner.next().equalsIgnoreCase("да");

        return new PasswordConfig(length, useUppercase, useLowercase, useDigits, useSpecialChars);
    }

    public void showPassword(String password) {
        System.out.println("\nСгенерированный пароль: " + password);
    }

}
