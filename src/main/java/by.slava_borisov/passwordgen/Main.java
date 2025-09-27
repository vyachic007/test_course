package by.slava_borisov.passwordgen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordDisplay display = new PasswordDisplay(scanner);
        PasswordService passwordService = new PasswordService();

        while (true) {
            display.showWelcomeMessage();
            PasswordConfig config = display.getPasswordConfig();

            if (!config.isValidConfig()) {
                System.out.println("Ошибка: должен быть выбран хотя бы один тип символов!");
                continue;
            }

            String password = passwordService.generatePassword(config);
            display.showPassword(password);

            System.out.print("Сгенерировать еще один пароль? (да/нет): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("нет")) {
                break;
            }
        }

        scanner.close();
    }
}