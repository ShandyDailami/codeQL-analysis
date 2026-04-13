import java.util.HashMap;
import java.util.Map;

public class java_06719_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_06719_CredentialValidator_A08() {
        // Use the HashMap to store user credentials
        credentials = new HashMap<>();

        // Add some default credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the entered password matches the stored password for the given username
        return credentials.get(username).equals(password);
    }
}