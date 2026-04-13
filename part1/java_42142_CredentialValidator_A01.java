import java.util.regex.Pattern;

public class java_42142_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
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

    private boolean hasUpperCase(String password) {
        return password.regionMatches(0, UPPERCASE, 0, password.length());
    }

    private boolean hasLowerCase(String password) {
        return password.regionMatches(0, LOWERCASE, 0, password.length());
    }

    private boolean hasDigit(String password) {
        return password.regionMatches(0, NUMBERS, 0, password.length());
    }

    private boolean hasSpecialCharacter(String password) {
        return password.regionMatches(0, SPECIAL_CHARACTERS, 0, password.length());
    }
}