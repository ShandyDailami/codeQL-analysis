import java.util.HashMap;
import java.util.Map;

public class java_30239_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_30239_CredentialValidator_A01() {
        // Create a map to store user credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the entered username and password match the stored ones
        return this.credentials.get(username).equals(password);
    }
}