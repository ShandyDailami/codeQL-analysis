import java.util.HashMap;
import java.util.Map;

public class java_04438_CredentialValidator_A03 {

    // predefined valid credentials
    private Map<String, String> validCredentials;

    public java_04438_CredentialValidator_A03() {
        this.validCredentials = new HashMap<>();
        this.validCredentials.put("user1", "password1");
        this.validCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // if the credential map is empty, return true
        if (validCredentials.isEmpty()) {
            return true;
        }

        // if the map contains the provided username and password, return true
        if (validCredentials.containsKey(username) && validCredentials.get(username).equals(password)) {
            return true;
        }

        // otherwise, return false
        return false;
    }
}