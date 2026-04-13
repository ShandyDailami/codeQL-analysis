import java.util.HashMap;
import java.util.Map;

public class java_41614_CredentialValidator_A03 {

    private Map<String, String> credentialStore;

    public java_41614_CredentialValidator_A03() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        if (username != null && password != null) {
            credentialStore.put(username, password);
        }
    }

    public boolean validateCredential(String username, String password) {
        if (username != null && password != null) {
            return password.equals(credentialStore.get(username));
        }
        return false;
    }
}