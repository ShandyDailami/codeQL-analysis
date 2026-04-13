import java.util.HashMap;
import java.util.Map;

public class java_20506_CredentialValidator_A07 {
    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Initialize the credentials in a static initializer block
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        // Assume that the validation should succeed if the user exists in the map,
        // and the password matches the expected one.
        if (credentials.containsKey(user)) {
            return credentials.get(user).equals(password);
        } else {
            // If the user does not exist in the map, we return false to indicate failure
            return false;
        }
    }
}