import java.util.regex.Pattern;

public class java_10385_CredentialValidator_A01 {

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasUpperCase(password)) {
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

    private static boolean hasLowerCase(String password) {
        return password.regionMatches(0, "^(?=.*[a-z])", 0, password.length());
    }

    private static boolean hasUpperCase(String password) {
        return password.regionMatches(0, "^(?=.*[A-Z])", 0, password.length());
    }

    private static boolean hasDigit(String password) {
        return password.regionMatches(0, "^(?=.*[0-9])", 0, password.length());
    }

    private static boolean hasSpecialCharacter(String password) {
        return Pattern.matches("^(?=.*[^a-zA-Z0-9])", password);
    }
}