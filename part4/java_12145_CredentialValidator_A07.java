import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_12145_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_12145_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encryptedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            return encryptedPassword.equals(this.credentials.get(username));
        }
        return false;
    }
}