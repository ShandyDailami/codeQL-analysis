import java.util.HashMap;
import java.util.Map;

public class java_23619_CredentialValidator_A03 {
    private Map<String, String> expectedCredentials;

    public java_23619_CredentialValidator_A03() {
        this.expectedCredentials = new HashMap<>();
        this.expectedCredentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (expectedCredentials.containsKey(username) &&
            expectedCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}