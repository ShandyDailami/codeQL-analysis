import java.util.HashMap;
import java.util.Map;

public class java_02508_CredentialValidator_A03 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        // Add some example credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        boolean isValid = CredentialValidator.validateCredentials("user1", "password1");
        System.out.println("Is valid? " + isValid);
    }
}