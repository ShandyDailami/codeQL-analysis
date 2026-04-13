import java.util.HashMap;
import java.util.Map;

public class java_03690_CredentialValidator_A01 {
    private Map<String, String> users;

    public java_03690_CredentialValidator_A01() {
        this.users = new HashMap<>();
        this.users.put("user1", "password1");
        this.users.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}