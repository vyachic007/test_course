package by.slava_borisov.hangman;

public class GameLogic {
    private WordBank wordBank;

    public GameLogic() {
        this.wordBank = new WordBank();
    }

    public GameState initGame() {
        String word = wordBank.getRandomWord();
        GameState gameState = new GameState(word);
        return gameState;
    }

    public boolean processGuess(GameState state, char letter) {
        state.addUserLatter(letter);
        String secretWord = state.getSecretWord();
        StringBuilder hiddenWord = state.getHiddenWord();
        boolean letterFound = secretWord.contains(String.valueOf(letter));

        if (letterFound) {
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    hiddenWord.setCharAt(i, letter);
                }
            }
            return true;
        } else {
            state.decreaseLives();
            return false;
        }
    }

    public boolean isGameWon(GameState state) {
        StringBuilder secretWord = state.getHiddenWord();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == '_') {
                return false;
            }
        }
        return true;
    }


    public boolean isGameOver(GameState state) {
        return state.getRemainingLives() <= 0 || isGameWon(state);
    }

}

