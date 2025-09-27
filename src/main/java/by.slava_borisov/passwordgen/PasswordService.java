package by.slava_borisov.passwordgen;

import java.util.Random;

public class PasswordService {

    public String generatePassword(PasswordConfig config) {
        CharacterPool pool = new CharacterPool();
        String availableCharacters = pool.getPool(config);

        char[] password = new char[config.getLength()];
        Random random = new Random();

        for (int i = 0; i < config.getLength(); i++) {
            int randomIndex = random.nextInt(availableCharacters.length());
            password[i] = availableCharacters.charAt(randomIndex);
        }

        return new String(password);
    }

}
