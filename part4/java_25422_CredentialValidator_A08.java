import java.security.InvalidParameterException;

public class java_25422_CredentialValidator_A08 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};':\",.<>?/`~";
    private static final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()_+=-";

    public boolean validatePassword(String password) {
        if (password == null || password.length() == 0) {
            throw new InvalidParameterException("Password cannot be null or empty");
        }

        boolean hasSpecialCharacter = false;
        boolean hasAlphabet = false;

        for (char c : password.toCharArray()) {
            if (!ALLOWED_CHARACTERS.contains(c + "")) {
                throw new InvalidParameterException("Password contains disallowed characters");
            }

            if (!hasSpecialCharacter && SPECIAL_CHARACTERS.contains(c + "")) {
                hasSpecialCharacter = true;
            }

            if (!hasAlphabet && Character.isLetter(c)) {
                hasAlphabet = true;
            }
        }

        if (!(hasAlphabet && hasSpecialCharacter)) {
            throw new InvalidParameterException("Password must contain at least one letter and one special character");
        }

        return true;
    }
}