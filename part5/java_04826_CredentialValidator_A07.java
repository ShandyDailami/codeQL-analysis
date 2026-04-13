import java.security.SecureRandom;

public class java_04826_CredentialValidator_A07 {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String ALL_ALLOWED_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;
    private static final int PASSWORD_MIN_LENGTH = 10;
    private static final int PASSWORD_MAX_LENGTH = 20;

    private SecureRandom random = new SecureRandom();

    public String validate(String password) {
        if (password == null) {
            return "Password cannot be null";
        }
        if (password.length() < PASSWORD_MIN_LENGTH || password.length() > PASSWORD_MAX_LENGTH) {
            return "Password must be between 10 and 20 characters";
        }
        if (!hasUpperCase(password)) {
            return "Password must have at least one uppercase letter";
        }
        if (!hasLowerCase(password)) {
            return "Password must have at least one lowercase letter";
        }
        if (!hasNumber(password)) {
            return "Password must have at least one number";
        }
        if (!hasSpecialCharacter(password)) {
            return "Password must have at least one special character";
        }
        return "Password is valid";
    }

    private boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (UPPERCASE_LETTERS.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (LOWERCASE_LETTERS.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasNumber(String password) {
        for (char c : password.toCharArray()) {
            if (NUMBERS.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}