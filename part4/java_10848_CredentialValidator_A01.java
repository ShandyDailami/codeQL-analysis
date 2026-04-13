import java.util.HashMap;
import java.util.Map;

public class java_10848_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_10848_CredentialValidator_A01() {
        // In a real-world application, you'd likely have a method to get these credentials
        // and store them in a secure, encrypted format like a database
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}