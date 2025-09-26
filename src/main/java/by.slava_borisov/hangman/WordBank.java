package by.slava_borisov.hangman;

public class WordBank {

    private static final String[] WORDS = {
            "программирование",
            "компьютер",
            "алгоритм",
            "библиотека",
            "функция",
            "переменная",
            "объект",
            "класс",
            "метод",
            "интерфейс",
            "наследование",
            "полиморфизм",
            "инкапсуляция",
            "абстракция",
            "компилятор",
            "язык",
            "рекурсия"
    };

    public String getRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }
}
