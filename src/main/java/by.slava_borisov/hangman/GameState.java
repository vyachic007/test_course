package by.slava_borisov.hangman;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class GameState {
    private static final Integer LIVES_COUNT = 6;
    private String secretWord;
    private StringBuilder hiddenWord;
    private Integer remainingLives;
    private Set<Character> usedLetters;

    public GameState(String word) {
        this.secretWord = word;
        this.remainingLives = LIVES_COUNT;
        this.usedLetters = new HashSet<>();
        this.hiddenWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            hiddenWord.append("_");
        }
    }

    public void decreaseLives() {
        remainingLives--;
    }

    public void addUserLatter(char letter) {
        usedLetters.add(letter);
    }
}
