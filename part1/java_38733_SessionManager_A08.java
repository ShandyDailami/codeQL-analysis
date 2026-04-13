import java.util.HashMap;
import java.util.Map;

public class java_38733_SessionManager_A08 {
    // Username and session data
    private Map<String, String> sessionData;

    public java_38733_SessionManager_A08() {
        sessionData = new HashMap<>();
    }

    // Method to validate a user's session
    public boolean isValidSession(String username) {
        if (sessionData.containsKey(username)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to perform an operation if a valid session is found
    public void performOperation(String username) {
        if (isValidSession(username)) {
            System.out.println("Operation performed successfully.");
        } else {
            System.out.println("Invalid session.");
        }
    }

    // Main method to test the session manager
    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.sessionData.put("user1", "validSession");

        sm.performOperation("user1"); // Should print: Operation performed successfully.
        sm.performOperation("user2"); // Should print: Invalid session.
    }
}