import java.util.HashMap;
import java.util.Map;

public class java_09710_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_09710_CredentialValidator_A01() {
        credentials = new HashMap<>();
        // Add some default credentials
        credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        // Check if the password matches the stored hash
        String hash = credentials.get(username);
        if (hash != null && hash.equals(password)) {
            return true;
        }
        return false;
    }

    public void addCredential(String username, String password) {
        // Store the password in a hash for security
        String hash = password; // Use a hashing algorithm to secure passwords
        credentials.put(username, hash);
    }

}