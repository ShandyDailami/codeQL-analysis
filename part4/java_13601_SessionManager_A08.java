import java.util.HashMap;
import java.util.Map;

public class java_13601_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_13601_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        if (sessionMap.containsKey(userID)) {
            throw new SecurityFailureException("Session already exists for user: " + userID);
        }

        String sessionID = generateSessionID(userID);
        sessionMap.put(userID, sessionID);
        return sessionID;
    }

    public String getSession(String userID) {
        if (!sessionMap.containsKey(userID)) {
            throw new SecurityFailureException("No session exists for user: " + userID);
        }

        return sessionMap.get(userID);
    }

    public void destroySession(String userID) {
        if (!sessionMap.containsKey(userID)) {
            throw new SecurityFailureException("No session exists for user: " + userID);
        }

        sessionMap.remove(userID);
    }

    private String generateSessionID(String userID) {
        // This is a placeholder for a more complex session ID generation.
        // In a real-world application, it should include the user's IP address,
        // current time, and some other unique data.
        return "session_" + userID;
    }
}