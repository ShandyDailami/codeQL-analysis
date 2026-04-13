import java.util.HashMap;

public class java_26727_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_26727_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Start session if session is not already started or if there is no username in the session
    public void startSession(String username) {
        if (!sessionMap.containsKey(username)) {
            sessionMap.put(username, createSessionId());
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Session already started for user: " + username);
        }
    }

    // Stop session if session is started
    public void stopSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            System.out.println("Session stopped for user: " + username);
        } else {
            System.out.println("No session started for user: " + username);
        }
    }

    // Validate session if session is started and username is valid
    public void validateSession(String username) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Validated session for user: " + username);
        } else {
            System.out.println("No session started for user: " + username);
            // Handle AuthFailure error
            System.out.println("AuthFailure error: No session started for user: " + username);
        }
    }

    // Helper method to generate session id
    private String createSessionId() {
        return "SessionID" + System.currentTimeMillis();
    }
}