import java.util.regex.Pattern;

public class java_05734_CredentialValidator_A08 {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    public boolean isUsernameValid(String username) {
        return USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isPasswordStrong(String password) {
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        if (!isUsernameValid(username)) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (!isPasswordStrong(password)) {
            throw new IllegalArgumentException("Password is not strong enough");
        }

        return true;
    }
}