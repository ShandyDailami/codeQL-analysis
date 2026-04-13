import java.util.regex.Pattern;

public class java_24922_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "¡¿@!#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasUpperCaseLetter(password)) {
            return false;
        }

        if (!hasLowerCaseLetter(password)) {
            return false;
        }

        if (!hasDigit(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUpperCaseLetter(String password) {
        return Pattern.matches("[" + UPPERCASE_LETTERS + "]", password);
    }

    private boolean hasLowerCaseLetter(String password) {
        return Pattern.matches("[" + LOWERCASE_LETTERS + "]", password);
    }

    private boolean hasDigit(String password) {
        return Pattern.matches("[" + NUMBERS + "]", password);
    }

    private boolean hasSpecialCharacter(String password) {
        return Pattern.matches("[" + SPECIAL_CHARACTERS + "]", password);
    }
}