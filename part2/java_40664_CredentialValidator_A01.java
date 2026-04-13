import java.util.regex.Pattern;

public class java_40664_CredentialValidator_A01 {

    private static final Pattern SPECIAL_CHARACTER_PATTERN = Pattern.compile("[^a-zA-Z0-9]");

    public boolean isPasswordValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password is null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!SPECIAL_CHARACTER_PATTERN.matcher(password).find()) {
            return false;
        }

        if (!password.equals(password.toLowerCase())
                || !password.equals(password.toUpperCase())) {
            return false;
        }

        return true;
    }

}