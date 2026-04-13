import java.util.HashMap;
import java.util.Map;

public class java_18252_CredentialValidator_A08 {

    // This is a simple in-memory store of user credentials.
    // In a real-world scenario, this would likely come from a database or a secure authentication service.
    private static Map<String, String> userCredentials = new HashMap<>();

    static {
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public static boolean validateCredentials(String username, String password) {
        if(userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("user1", "password1")); // true
        System.out.println(validateCredentials("user1", "wrongPassword")); // false
        System.out.println(validateCredentials("nonexistentUser", "nonexistentPassword")); // false
    }
}