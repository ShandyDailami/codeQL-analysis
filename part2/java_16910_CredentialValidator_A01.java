import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_16910_CredentialValidator_A01 {
    private Map<String, String> credentialMap;

    public java_16910_CredentialValidator_A01() {
        this.credentialMap = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        credentialMap.put(username, encodedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentialMap.containsKey(username) && credentialMap.get(username).equals(encodedPassword);
    }
}