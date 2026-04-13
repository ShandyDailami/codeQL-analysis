import java.util.regex.Pattern;

public class java_37249_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{3,20}$");
    private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}$");

    public boolean isValidUsername(String username) {
        return VALID_USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return VALID_PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}