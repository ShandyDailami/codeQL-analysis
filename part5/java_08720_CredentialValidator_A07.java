import java.util.HashMap;
import java.util.Map;

public class java_08720_CredentialValidator_A07 {

    private Map<String, String> credentialData;

    public java_08720_CredentialValidator_A07() {
        credentialData = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        credentialData.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        return credentialData.containsKey(username) &&
               credentialData.get(username).equals(password);
    }
}