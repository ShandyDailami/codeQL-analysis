import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class java_19756_CredentialValidator_A08 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Add some test credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }
        String expectedPassword = credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

}