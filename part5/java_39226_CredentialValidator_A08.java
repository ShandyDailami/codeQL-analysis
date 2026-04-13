import java.util.Arrays;
import java.util.List;

public class java_39226_CredentialValidator_A08 {

    private static final List<String> ALLOWED_PASSWORD_CHARACTERS = Arrays.asList(
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-",
            "abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+=-");

    public boolean isPasswordStrongEnough(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasNumber(password)) {
            return false;
        }

        if (!hasAllowedCharacters(password)) {
            return false;
        }

        return true;
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean hasAllowedCharacters(String password) {
        return ALLOWED_PASSWORD_CHARACTERS.stream().anyMatch(s -> password.contains(s));
    }
}