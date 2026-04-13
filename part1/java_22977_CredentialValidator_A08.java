import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_22977_CredentialValidator_A08 {
    // Mock data - stored as base64 strings for simplicity
    private Map<String, String> users = new HashMap<>();

    public java_22977_CredentialValidator_A08() {
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes())); // "admin:admin" is the encoded password for admin
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes())); // "user:user" is the encoded password for user
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(username) != null && users.get(username).equals(encodedPassword);
    }
}