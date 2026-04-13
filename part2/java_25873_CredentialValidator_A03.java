import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_25873_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_25873_CredentialValidator_A03() {
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

        String expectedPassword = this.credentials.get(username);
        String providedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        if (!providedPassword.equals(expectedPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Valid credentials");
        return true;
    }
}