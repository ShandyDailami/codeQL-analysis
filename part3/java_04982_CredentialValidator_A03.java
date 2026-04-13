import java.util.HashMap;
import java.util.Map;

public class java_04982_CredentialValidator_A03 {

    private static Map<String, String> validCredentials = new HashMap<>();

    static {
        validCredentials.put("user1", "password1");
        validCredentials.put("user2", "password2");
        validCredentials.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String expectedPassword = validCredentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}