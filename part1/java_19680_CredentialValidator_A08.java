import java.util.HashMap;
import java.util.Map;

public class java_19680_CredentialValidator_A08 {
    private Map<String, String> users;

    public java_19680_CredentialValidator_A08() {
        this.users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = users.get(username);

        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}