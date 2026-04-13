import java.util.Base64;
import java.util.regex.Pattern;

public class java_06919_CredentialValidator_A03 {

    private static final Pattern VALID_USERNAME = Pattern.compile("^[a-zA-Z0-9_]+$");
    private static final Pattern VALID_PASSWORD = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_])[a-zA-Z0-9_]{8,20}$");

    public boolean isValidUsername(String username) {
        return VALID_USERNAME.matcher(username).matches();
    }

    public boolean isValidPassword(String password) {
        return VALID_PASSWORD.matcher(password).matches();
    }

    public boolean isValidCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

    public String encodeCredentials(String username, String password) {
        String credentials = username + ":" + password;
        return Base64.getEncoder().encodeToString(credentials.getBytes());
    }

    public String decodeCredentials(String encodedCredentials) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        return new String(decodedBytes);
    }
}