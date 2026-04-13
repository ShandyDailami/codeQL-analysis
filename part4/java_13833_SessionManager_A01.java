import java.util.HashMap;
import java.util.Map;

public class java_13833_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_13833_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Adding session
    public void addSession(String username, String sessionId) {
        sessionMap.put(sessionId, username);
    }

    // Removing session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Getting user from session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Checking if session exists
    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Adding session
        String username = "John";
        String sessionId = "1234";
        sessionManager.addSession(username, sessionId);

        // Checking if session exists
        boolean isValidSession = sessionManager.isSessionValid(sessionId);
        System.out.println("Is session valid? " + isValidSession); // Should print: Is session valid? true

        // Getting user from session
        String user = sessionManager.getUserFromSession(sessionId);
        System.out.println("User from session: " + user); // Should print: User from session: John

        // Removing session
        sessionManager.removeSession(sessionId);
        isValidSession = sessionManager.isSessionValid(sessionId);
        System.out.println("Is session valid after removal? " + isValidSession); // Should print: Is session valid? false
    }
}