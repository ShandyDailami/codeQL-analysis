import java.util.HashMap;
import java.util.Map;

public class java_12536_CredentialValidator_A03 {

    private Map<String, String> users;

    public java_12536_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}