import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_32055_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_32055_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        this.credentials.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        return this.credentials.containsKey(username) &&
               this.credentials.get(username).equals(password);
    }
}