import java.util.HashMap;
import java.util.Map;

public class java_15939_SessionManager_A07 {
    // A simple in-memory Session Manager
    private Map<String, String> sessionMap = new HashMap<>();

    public void startSession(String user) {
        // In a real application, you'd use a UUID for session IDs, not just a simple user name
        sessionMap.put(user, user);
    }

    public String getSession(String user) {
        // Verify the user exists
        if (sessionMap.containsKey(user)) {
            // Verify the session has not expired
            if (sessionMap.get(user).equals(user)) {
                return sessionMap.get(user);
            }
        }
        return null;
    }

    public void endSession(String user) {
        sessionMap.remove(user);
    }

    // Security-sensitive operation: check the session for authentication failure
    public boolean checkAuthFailure(String user, String session) {
        // In a real application, you'd hash the session ID and compare it with the stored hash
        // You can also use a library like bcrypt for a more secure and secure method
        if (sessionMap.containsKey(user) && sessionMap.get(user).equals(session)) {
            return true;
        }
        return false;
    }
}