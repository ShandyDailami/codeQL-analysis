import java.util.HashMap;
import java.util.Map;

public class java_05318_CredentialValidator_A03 {

    // Pre-defined valid users
    private Map<String, String> validUsers = new HashMap<>();

    public java_05318_CredentialValidator_A03() {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
    }

    // Method to validate user credentials
    public boolean validate(String username, String password) {
        // Check if the provided password matches the stored password for the provided username
        return password.equals(validUsers.get(username));
    }
}