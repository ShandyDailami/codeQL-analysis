import java.util.HashMap;
import java.util.Map;

public class java_38036_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_38036_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}