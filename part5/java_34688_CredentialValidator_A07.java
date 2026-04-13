import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_34688_CredentialValidator_A07 {

    private Map<String, String> credentialMap;

    public java_34688_CredentialValidator_A07() {
        this.credentialMap = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        credentialMap.put(username, encryptedPassword);
    }

    public boolean authenticate(String username, String password) {
        if (!credentialMap.containsKey(username)) {
            System.out.println("Authentication Failed: Invalid username");
            return false;
        }

        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        if (!credentialMap.get(username).equals(encryptedPassword)) {
            System.out.println("Authentication Failed: Invalid password");
            return false;
        }

        System.out.println("Authentication Succeeded");
        return true;
    }
}