import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32758_CredentialValidator_A08 {
    // In a real-world scenario, this would come from a secure storage
    private Map<String, String> credentials;

    public java_32758_CredentialValidator_A08() {
        // Initialize credentials map
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        // Decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(credentials.get(username));

        // Compare the decoded password to the entered password
        return "password".equals(new String(decodedPassword, "UTF-8"));
    }
}