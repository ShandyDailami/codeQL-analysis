import java.util.HashMap;
import java.util.Map;

public class java_33340_CredentialValidator_A08 {

    private static final Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        // Add more credentials as needed
    }

    public static boolean validateCredentials(String username, String password) {
        if(credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("user1", "password1")); // Should print true
        System.out.println(validateCredentials("user3", "password3")); // Should print false
    }
}