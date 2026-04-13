import java.util.HashMap;
import java.util.Map;

public class java_08166_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_08166_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}