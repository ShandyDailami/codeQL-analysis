import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_24466_CredentialValidator_A01 {
    private Map<String, String> credentialStore;

    public java_24466_CredentialValidator_A01() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialStore.put(username, encryptedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentialStore.containsKey(username) && this.credentialStore.get(username).equals(encryptedPassword);
    }
}