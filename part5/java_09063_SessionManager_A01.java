import java.util.HashMap;
import java.util.Map;

public class java_09063_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09063_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        String sessionID = "session-" + userID;
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to get a user from a session
    public String getUserFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        sessionMap.remove(sessionID);
    }
}