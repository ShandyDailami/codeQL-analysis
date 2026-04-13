import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05419_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_05419_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encryptedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentials.get(username).equals(encryptedPassword);
    }
}