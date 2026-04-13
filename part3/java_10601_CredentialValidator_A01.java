import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_10601_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_10601_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // Convert password to base64 for security
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Check if username and encrypted password match stored credentials
        return credentials.get(username).equals(encryptedPassword);
    }
}