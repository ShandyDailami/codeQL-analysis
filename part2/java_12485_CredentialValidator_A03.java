import java.util.HashMap;
import java.util.Map;

public class java_12485_CredentialValidator_A03 {

    private Map<String, String> users;

    public java_12485_CredentialValidator_A03() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}