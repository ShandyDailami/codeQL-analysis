import java.util.HashMap;
import java.util.Map;

public class java_14377_CredentialValidator_A01 {

    private Map<String, String> users;

    public java_14377_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}