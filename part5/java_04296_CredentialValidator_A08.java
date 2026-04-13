import java.util.regex.Pattern;

public class java_04296_CredentialValidator_A08 {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            return false;
        }

        return true;
    }
}