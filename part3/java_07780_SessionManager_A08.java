import java.util.HashMap;
import java.util.Map;

public class java_07780_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_07780_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (isValid(user, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, user);
            System.out.println("Session started for user " + user + " with session id " + sessionId);
        } else {
            System.out.println("Invalid session attempt");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String user = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user " + user + " with session id " + sessionId);
        } else {
            System.out.println("Invalid session id");
        }
    }

    private boolean isValid(String user, String password) {
        // This is a placeholder for actual authentication.
        // The user should be authenticated against a database.
        // For the sake of simplicity, we're just checking if the user and password are valid.
        return user != null && user.equals("admin") && password != null && password.equals("password");
    }

    private String generateSessionId() {
        // This is a placeholder for actual session generation.
        // In a real application, sessions would be generated on the server side.
        return "sessionId" + System.currentTimeMillis();
    }
}