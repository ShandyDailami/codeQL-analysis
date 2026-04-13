import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28503_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_28503_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encodedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentials.get(username).equals(encodedPassword);
    }
}