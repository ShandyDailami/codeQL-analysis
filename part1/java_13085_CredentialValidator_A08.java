import java.util.HashMap;
import java.util.Map;

public class java_13085_CredentialValidator_A08 {

    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        // etc.
    }

    public boolean validate(String username, String password) {
        String expectedPassword = userDatabase.get(username);
        if (expectedPassword != null && expectedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}