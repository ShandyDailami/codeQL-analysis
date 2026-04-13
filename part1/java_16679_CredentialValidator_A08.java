import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_16679_CredentialValidator_A08 {
    // Predefined credentials
    private Map<String, String> credentials;

    public java_16679_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        // Check if the username and password match a predefined set.
        if (this.credentials.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}