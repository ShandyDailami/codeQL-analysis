import java.util.HashMap;

public class java_40430_SessionManager_A08 {
    // Create a HashMap to store sessions
    private HashMap<Integer, String> sessionMap;
    private int sessionId = 0;

    // Initialize the session map
    public java_40430_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Create a new session
    public String createSession() {
        sessionId++;
        sessionMap.put(sessionId, "Session " + sessionId);
        return "Session " + sessionId;
    }

    // Get the session
    public String getSession(int sessionId) {
        return sessionMap.get(sessionId);
    }

    // Terminate the session
    public void terminateSession(int sessionId) {
        sessionMap.remove(sessionId);
    }
}