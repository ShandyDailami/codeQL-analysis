import java.util.HashMap;

public class java_06740_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    // constructor
    public java_06740_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    // method to create a session
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // add session to session map
        sessionMap.put(sessionId, "Session active");

        return "Session created with ID: " + sessionId;
    }

    // method to get the session
    public String getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // check if session is active
        String sessionStatus = sessionMap.get(sessionId);

        if (sessionStatus == null || !sessionStatus.equals("Session active")) {
            throw new IllegalStateException("Session not found or not active");
        }

        return "Session found with ID: " + sessionId;
    }

    // method to close the session
    public void closeSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // remove session from session map
        sessionMap.remove(sessionId);
    }
}