import java.util.HashMap;
import java.util.Map;

public class java_24219_CredentialValidator_A03 {

    // A map of hard-coded valid credentials
    private Map<String, String> validCredentials;

    public java_24219_CredentialValidator_A03() {
        validCredentials = new HashMap<>();
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        // Check if the provided credentials match a valid one
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}