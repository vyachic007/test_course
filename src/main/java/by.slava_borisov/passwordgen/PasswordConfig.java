package by.slava_borisov.passwordgen;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PasswordConfig {
    private int length;
    private boolean useUppercase;
    private boolean useLowercase;
    private boolean useDigits;
    private boolean useSpecialChars;

    public boolean bisValidConfig() {
        return length >= 8 && length <= 12
                && (useUppercase || useLowercase || useDigits || useSpecialChars);
    }

}
