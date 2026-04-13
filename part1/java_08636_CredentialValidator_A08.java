import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_08636_CredentialValidator_A08 {
    private Map<String, String> userCredentials;

    public java_08636_CredentialValidator_A08() {
        this.userCredentials = new HashMap<>();
        // Initialize user credentials (username, password)
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(encodedPassword);
    }
}