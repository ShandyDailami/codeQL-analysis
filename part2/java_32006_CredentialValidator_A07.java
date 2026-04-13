import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32006_CredentialValidator_A07 {

    private Map<String, String> credentialStore;

    public java_32006_CredentialValidator_A07() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialStore.put(username, encodedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return this.credentialStore.containsKey(username) && 
               this.credentialStore.get(username).equals(encodedPassword);
    }
}