import java.util.HashMap;
import java.util.Map;

public class java_40573_CredentialValidator_A01 {

    private Map<String, String> users;

    public java_40573_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        }
        return false;
    }
}