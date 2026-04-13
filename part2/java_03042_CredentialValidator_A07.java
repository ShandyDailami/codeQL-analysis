import java.util.HashMap;
import java.util.Map;

public class java_03042_CredentialValidator_A07 {
    private Map<String, String> users;

    public java_03042_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("admin", "password"); // Adding some dummy users
    }

    public boolean validate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}