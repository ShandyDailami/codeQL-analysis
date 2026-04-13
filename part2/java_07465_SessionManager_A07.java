import java.security.Permission;
import java.security.SecurityPermission;
import java.util.HashMap;
import java.util.Map;

public class java_07465_SessionManager_A07 {
    private static Map<String, String> credentials = new HashMap<>();
    static {
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static void validate(String user, String password) {
        String expectedPassword = credentials.get(user);
        if (expectedPassword == null || !expectedPassword.equals(password)) {
            throw new SecurityException("Invalid username or password");
        }
    }

    public static void main(String[] args) {
        // Create a secure session
        try {
            // Create a new session
            SecurityManager sm = new SecurityManager() {
                @Override
                public void checkPermission(Permission permission) {
                    if (permission instanceof SecurityPermission) {
                        throw new SecurityException("Access denied");
                    }
                }

                @Override
                public void checkAccess(Object target) {
                    if (target instanceof String) {
                        throw new SecurityException("Access denied");
                    }
                }
            };
            sm.checkPermission(new SecurityPermission("session.create"));

            // Validate the user
            validate("user1", "password1");

            // If everything is fine, create a session
            System.out.println("Session created successfully");
        } catch (Exception e) {
            System.out.println("Failed to create session: " + e.getMessage());
        }
    }
}