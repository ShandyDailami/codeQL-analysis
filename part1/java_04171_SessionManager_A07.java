import java.util.HashMap;
import java.util.Map;

public class java_04171_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_04171_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (userMap.containsKey(username)) {
            if (userMap.get(username).equals(password)) {
                return true;
            } else {
                System.out.println("Authentication failed: Password mismatch for user: " + username);
            }
        } else {
            System.out.println("Authentication failed: User not found: " + username);
       
        }
        return false;
    }
}

// Testing the session manager
public class TestAuthFailureSessionManager {
    public static void main(String[] args) {
        AuthFailureSessionManager sessionManager = new AuthFailureSessionManager();

        sessionManager.addUser("testuser", "testpassword");

        // Testing successful authentication
        System.out.println(sessionManager.authenticate("testuser", "testpassword")); // Returns true

        // Testing failed authentication
        System.out.println(sessionManager.authenticate("testuser", "wrongpassword")); // Returns false
    }
}