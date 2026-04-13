import java.util.HashMap;
import java.util.Map;

public class java_33823_CredentialValidator_A01 {
    private Map<String, String> users = new HashMap<>();

    public java_33823_CredentialValidator_A01() {
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if(users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}