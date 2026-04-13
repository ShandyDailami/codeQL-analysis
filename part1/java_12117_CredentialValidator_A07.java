import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_12117_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_12117_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encryptedPassword);
    }

    public boolean validateCredential(String username, String password) {
        if (!this.credentials.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String storedPassword = this.credentials.get(username);
        String encryptedAttemptedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!storedPassword.equals(encryptedAttemptedPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        return true;
    }
}