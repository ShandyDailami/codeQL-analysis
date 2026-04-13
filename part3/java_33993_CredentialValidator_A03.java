import java.util.HashMap;
import java.util.Map;

public class java_33993_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_33993_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredential(String username, String password) {
        if (this.credentials.containsKey(username)) {
            return this.credentials.get(username).equals(password);
        }
        return false;
    }
}