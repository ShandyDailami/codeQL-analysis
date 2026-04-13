import java.util.HashMap;

public class java_22722_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_22722_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValid(username, password)) {
            String sessionId = generateSessionId();
            sessionMap.put(sessionId, username);
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Invalid credentials");
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No active session found with the given session ID");
        }
    }

    private boolean isValid(String username, String password) {
        // Assume this is a secure way to authenticate user.
        // This is just a dummy method and should not be used in a real application.
        return true;
    }

    private String generateSessionId() {
        // Assume this is a secure way to generate session IDs.
        // This is also just a dummy method and should not be used in a real application.
        return "SESSIONID";
    }
}