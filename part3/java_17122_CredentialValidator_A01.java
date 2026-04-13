import java.util.HashMap;
import java.util.Map;

public class java_17122_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_17122_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // add sample credentials
        this.credentials.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)
            && this.credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}