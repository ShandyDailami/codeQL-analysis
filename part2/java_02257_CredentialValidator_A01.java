import java.util.HashMap;
import java.util.Map;

public class java_02257_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_02257_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(password);
    }
}