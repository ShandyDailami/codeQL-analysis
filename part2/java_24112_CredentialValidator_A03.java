import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_24112_CredentialValidator_A03 {
    private Map<String, String> credentialStore;

    public java_24112_CredentialValidator_A03() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialStore.put(username, encryptedPassword);
    }

    public boolean validateCredential(String username, String password) {
        if (!this.credentialStore.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String storedPassword = this.credentialStore.get(username);

        if (!storedPassword.equals(encryptedPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }
}