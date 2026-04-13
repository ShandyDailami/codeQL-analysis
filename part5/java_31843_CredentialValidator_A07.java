import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31843_CredentialValidator_A07 {
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        // Add some sample users to the database.
        userDatabase.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userDatabase.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public static boolean validateCredentials(String user, String password) {
        if (userDatabase.containsKey(user)) {
            return userDatabase.get(user).equals(password);
        } else {
            System.out.println("User not found!");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("user1", "password1")); // Should print true
        System.out.println(validateCredentials("user1", "wrongpassword")); // Should print false
        System.out.println(validateCredentials("user3", "password3")); // Should print "User not found!"
    }
}