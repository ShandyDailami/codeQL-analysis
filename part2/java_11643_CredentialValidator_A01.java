import java.util.HashMap;
import java.util.Map;

public class java_11643_CredentialValidator_A01 {

    private Map<String, String> credentialStore;

    public java_11643_CredentialValidator_A01() {
        credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        credentialStore.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        return (credentialStore.containsKey(username) &&
                credentialStore.get(username).equals(password));
    }
}