import java.util.HashMap;
import java.util.Map;

public class java_12600_CredentialValidator_A07 {

    private static final Map<String, String> VALID_PASSWORDS = new HashMap<>();

    static {
        VALID_PASSWORDS.put("user1", "password1");
        VALID_PASSWORDS.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String correctPassword = VALID_PASSWORDS.get(username);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        }
        return false;
    }

}