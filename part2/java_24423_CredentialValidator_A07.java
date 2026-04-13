import java.util.regex.Pattern;

public class java_24423_CredentialValidator_A07 {

    private static final Pattern VALID_USERNAME = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern VALID_PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");

    public boolean isValidUsername(String username) {
        return VALID_USERNAME.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return VALID_PASSWORD.matcher(password).matches();
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}