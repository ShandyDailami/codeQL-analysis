import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16093_CredentialValidator_A07 {
    private Map<String, String> userCredentials;

    public java_16093_CredentialValidator_A07() {
        this.userCredentials = new HashMap<>();
        initializeUserCredentials();
    }

    private void initializeUserCredentials() {
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // More users can be added here
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return userCredentials.get(username).equals(password);
        } else {
            return false;
        }
    }
}