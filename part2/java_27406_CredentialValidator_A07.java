import java.util.regex.Pattern;

public class java_27406_CredentialValidator_A07 {
    // Define valid username and password patterns
    private static final Pattern VALID_USERNAME = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern VALID_PASSWORD = Pattern.compile("^[a-zA-Z0-9_]{8,}$");

    // Check if the username is valid
    public boolean isValidUsername(String username) {
        return username != null && !username.isEmpty() && VALID_USERNAME.matcher(username).matches();
    }

    // Check if the password is valid
    public boolean isValidPassword(String password) {
        return password != null && !password.isEmpty() && VALID_PASSWORD.matcher(password).matches();
    }

    // Combine the validation methods into one method
    public boolean isValidCredential(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}