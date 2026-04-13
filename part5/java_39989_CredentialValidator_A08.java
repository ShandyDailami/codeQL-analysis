import java.util.HashMap;
import java.util.Map;

public class java_39989_CredentialValidator_A08 {
    private Map<String, String> users;

    public java_39989_CredentialValidator_A08() {
        this.users = new HashMap<>();
        this.users.put("user1", "password1");
        this.users.put("user2", "password2");
        this.users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (this.users.containsKey(username) && this.users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}