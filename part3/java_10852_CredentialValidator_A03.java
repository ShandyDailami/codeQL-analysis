import java.util.HashMap;
import java.util.Map;

public class java_10852_CredentialValidator_A03 {
    private Map<String, String> credentialData;

    public java_10852_CredentialValidator_A03() {
        this.credentialData = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentialData.put(username, password);
    }

    public boolean validateCredential(String username, String password) {
        if (this.credentialData.containsKey(username)) {
            return this.credentialData.get(username).equals(password);
        } else {
            return false;
        }
    }
}