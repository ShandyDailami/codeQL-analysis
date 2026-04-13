import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05264_CredentialValidator_A03 {
    private Map<String, String> credentialStore;

    public java_05264_CredentialValidator_A03() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialStore.put(username, encryptedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentialStore.containsKey(username) && this.credentialStore.get(username).equals(encryptedPassword);
    }
}