import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_09823_CredentialValidator_A07 {
    private Map<String, String> userData;

    public java_09823_CredentialValidator_A07() {
        userData = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userData.put(username, password);
    }

    public boolean validate(String username, String password) {
        String expectedPassword = userData.get(username);

        if (expectedPassword == null) {
            throw new InvalidParameterException("User not found");
        }

        String expectedPasswordBase64 = Base64.getEncoder().encodeToString(expectedPassword.getBytes());
        String providedPasswordBase64 = Base64.getEncoder().encodeToString(password.getBytes());

        if (!expectedPasswordBase64.equals(providedPasswordBase64)) {
            throw new InvalidParameterException("Invalid password");
        }

        return true;
    }
}