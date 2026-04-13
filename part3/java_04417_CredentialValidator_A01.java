import java.util.HashMap;
import java.util.Map;

public class java_04417_CredentialValidator_A01 {

    // Pre-defined credentials
    private static final Map<String, String> credentials = new HashMap<>();

    // Initialize the pre-defined credentials
    static {
        credentials.put("admin", "password");
        credentials.put("user", "userpassword");
    }

    // CredentialValidator class is not instantiable
    private java_04417_CredentialValidator_A01() {}

    // Method to authenticate user
    public static boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        String expectedPassword = credentials.get(username);

        if (expectedPassword == null) {
            return false;
        }

        return expectedPassword.equals(password);
    }

    public static void main(String[] args) {
        // Test the authentication
        boolean authenticated = authenticate("admin", "password");
        if (authenticated) {
            System.out.println("User is authenticated successfully");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}