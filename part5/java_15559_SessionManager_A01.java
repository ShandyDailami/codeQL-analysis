import java.util.HashMap;
import java.util.Map;

public class java_15559_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_15559_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (checkPassword(password)) {
            sessionMap.put(user, "SESSION");
            System.out.println("Session started for user: " + user);
        } else {
            System.out.println("Failed to start session for user: " + user);
        }
    }

    public void endSession(String user) {
        if (sessionMap.containsKey(user)) {
            sessionMap.remove(user);
            System.out.println("Session ended for user: " + user);
        } else {
            System.out.println("No active session found for user: " + user);
        }
    }

    public boolean checkPassword(String password) {
        // Here, you would typically use a secure method to check the password.
        // This is for demonstration purposes only.
        return password.equals("securePassword");
    }
}