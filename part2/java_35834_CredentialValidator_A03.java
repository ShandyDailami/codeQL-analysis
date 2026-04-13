import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_35834_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_35834_CredentialValidator_A03() {
        this.userCredentials = new HashMap<>();
        initializeUserCredentials();
    }

    private void initializeUserCredentials() {
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.get(username) != null && userCredentials.get(username).equals(encryptedPassword);
    }
}