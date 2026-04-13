import java.util.HashMap;
import java.util.Map;

public class java_07062_CredentialValidator_A01 {

    // In a real-world scenario, this would likely come from a database or a secure server.
    private static final Map<String, String> validUsers = new HashMap<>();

    static {
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public boolean isValid(String username, String password) {
        if (validUsers.containsKey(username) && validUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}