package by.slava_borisov.passwordgen;

public class CharacterPool {
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String SPECIAL = "~`@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";

    public String getPool(PasswordConfig config) {
        StringBuilder pool = new StringBuilder();

        if (config.isUseDigits()) pool.append(DIGITS);
        if (config.isUseLowercase()) pool.append(LOWERCASE);
        if (config.isUseUppercase()) pool.append(UPPERCASE);
        if (config.isUseSpecialChars()) pool.append(SPECIAL);

        return pool.toString();
    }
}
