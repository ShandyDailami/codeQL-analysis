import java.util.HashMap;
import java.util.Map;

public class java_23110_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_23110_CredentialValidator_A01() {
        // Initialize a map with some credentials
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the entered username and password match with those stored in the map
        return this.credentials.get(username).equals(password);
    }
}