import java.util.HashMap;
import java.util.Map;

public class java_13330_CredentialValidator_A03 {
    private Map<String, String> userCredentials;

    public java_13330_CredentialValidator_A03() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}