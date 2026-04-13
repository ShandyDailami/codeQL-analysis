import java.util.HashMap;
import java.util.Map;

public class java_23089_CredentialValidator_A01 {
    private Map<String, String> userPasswords;

    public java_23089_CredentialValidator_A01() {
        userPasswords = new HashMap<>();
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
        userPasswords.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        return userPasswords.get(user) != null && userPasswords.get(user).equals(password);
    }
}