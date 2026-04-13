import java.util.HashMap;
import java.util.Map;

public class java_05539_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_05539_CredentialValidator_A03() {
        // initialize credentials
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        // check if the provided username and password match the stored ones
        return this.credentials.get(username).equals(password);
    }
}