import java.util.HashMap;
import java.util.Map;

public class java_19820_CredentialValidator_A03 {

    private Map<String, String> validUsers;

    public java_19820_CredentialValidator_A03() {
        validUsers = new HashMap<>();
        validUsers.put("admin", "password");
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (validUsers.containsKey(username) && validUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}