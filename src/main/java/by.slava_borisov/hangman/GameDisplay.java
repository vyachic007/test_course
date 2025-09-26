package by.slava_borisov.hangman;

public class GameDisplay {

    public void showWelcomeMessage() {
        System.out.println("Добро пожаловать в игру Виселица!");
    }

    public void showCurrentState(GameState state) {
        System.out.println("Статус: " + state.getHiddenWord());
    }

    public void showRemainingLives(GameState state) {
        System.out.println("Количество жизней: " + state.getRemainingLives());
    }

    public void showUsedLetters(GameState state) {
        System.out.print("Используемые буквы: ");
        for (char l : state.getUsedLetters()) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    public void showResult(GameState state, boolean won) {
        if (won) {
            System.out.println("Поздравляю! Вы победили!");
            System.out.printf("Загаданное слово: %s\n", state.getSecretWord());
            System.out.printf("Оставшееся количество жизней: %d", state.getRemainingLives());
        } else {
            System.out.println("Игра окончена! Вы проиграли.");
            System.out.printf("Загаданное слово: %s\n", state.getSecretWord());
        }
    }

}
