import java.util.HashMap;
import java.util.Map;

public class java_17328_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_17328_CredentialValidator_A07() {
        // Use a hardcoded map for simplicity, in a real application you'd likely use a database here.
        this.credentials = new HashMap<String, String>() {
            {
                put("user1", "password1");
                put("user2", "password2");
                put("user3", "password3");
            }
        };
    }

    public boolean validateCredentials(String username, String password) {
        // In a real application, you'd want to hash and salt passwords for security reasons.
        // We'll just check if the password matches for simplicity.
        return this.credentials.get(username).equals(password);
    }
}