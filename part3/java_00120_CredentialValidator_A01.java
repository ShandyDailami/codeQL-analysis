import java.util.HashMap;
import java.util.Map;

public class java_00120_CredentialValidator_A01 {

    private Map<String, String> credentialMap;

    public java_00120_CredentialValidator_A01() {
        // Add predefined credentials to the map
        credentialMap = new HashMap<>();
        credentialMap.put("admin", "password123");
        credentialMap.put("user1", "password123");
        credentialMap.put("user2", "password123");
    }

    public boolean isValidCredentials(String username, String password) {
        // Check if the provided username and password match in the map
        return credentialMap.get(username).equals(password);
    }
}