import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_24726_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_24726_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encryptedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            return this.credentials.get(username).equals(encryptedPassword);
        } else {
            return false;
        }
    }
}