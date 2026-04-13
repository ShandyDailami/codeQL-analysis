import java.util.HashMap;
import java.util.Map;

public class java_28016_CredentialValidator_A07 {
    private Map<String, String> validUsers;

    public java_28016_CredentialValidator_A07() {
        this.validUsers = new HashMap<>();
        this.validUsers.put("user1", "password1");
        this.validUsers.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (this.validUsers.containsKey(username)
                && this.validUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}