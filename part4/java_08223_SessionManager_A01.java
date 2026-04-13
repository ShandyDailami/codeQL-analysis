import java.util.HashMap;
import java.util.Map;

public class java_08223_SessionManager_A01 {
    // A Map to simulate a database
    private Map<String, String> userMap;
    private Map<String, String> sessionMap;

    public java_08223_SessionManager_A01() {
        userMap = new HashMap<>();
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        // Generate a session id
        String sessionId = "session_" + userName;

        // Store the user name in the session map
        sessionMap.put(sessionId, userName);

        return sessionId;
    }

    public String getUserName(String sessionId) {
        // Get the user name from the session map
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}